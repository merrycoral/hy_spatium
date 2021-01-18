package com.urban.spatium.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.CalcWait;
import com.urban.spatium.mapper.CalcMapper;

@Service
@Transactional
public class CalcService {
		@Autowired
		private CalcMapper calcMapper;
		
		public Map<String, Object> getDailyCalc (String sessionId, int sessionLevel) {
			List<Map<String, Object>> dailyCalcList = calcMapper.getDailyCalc(sessionId, sessionLevel);
			Map<String, Object> storeInfo = calcMapper.getStoreInfo(sessionId);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("dailyCalcList", dailyCalcList);
			resultMap.put("storeInfo", storeInfo);
			
			return resultMap;
		}
		
		public String CloseCalc(String today){
			//매일 0시에 일별 매출 마감 등록되는 메서드입니다.
			//업체 id 목록 가져오기
			List<Map<String, Object>> storeIdList = calcMapper.getStoreIdList();
			System.out.println("PRINT storeIdList");
			System.out.println(storeIdList);
			//업체 id 목록에서 id 하나하나씩 일 마감정산을 진행합니다.
			for(int i=0; i<storeIdList.size();i++) {
				int storeCode = Integer.parseInt(storeIdList.get(i).get("storeCode").toString());
				// SID는 i번째 스토어 아이디
				// getTodayList 에서는 SID가 sessionId이지만 현재 메서드에서는 SID가 i번째 스토어 아이디입니다.
				String SID = storeIdList.get(i).get("storeId").toString();
				List<Map<String, Object>> getTodayTotal = calcMapper.getTodayTotal(today, SID);
				System.out.println(getTodayTotal.size() + "  getTodayTotal size");
				
				if(getTodayTotal.size() > 0) {
					// 정산 데이터가 있을 경우
					Map<String, Object> todaytotal = getTodayTotal.get(getTodayTotal.size()-1);
					System.out.println(todaytotal + " <-- todaytotal");
					Map<String, Object> lastParam = getTodayTotal.get(getTodayTotal.size()-1);
					int moneySubtotal = Integer.parseInt(getTodayTotal.get(getTodayTotal.size()-1).get("moneySubtotal").toString());
					int refundSubtotal = Integer.parseInt(getTodayTotal.get(getTodayTotal.size()-1).get("refundSubtotal").toString());
					System.out.println(lastParam.get("refundMoney"));
					lastParam.put("storeCode", storeCode);
					lastParam.put("SID", SID);
					lastParam.put("today", today);
					calcMapper.insertDayClose(lastParam);
				}else {
					// 정산 할 날짜의 데이터가 없는 경우
					System.out.println("!= 조건 안 통과");
					System.out.println(today + SID + "  there is no data");
					Map<String, Object> lastParam = new HashMap<String, Object>(); 
					lastParam.put("countSubtotal", 0);
					lastParam.put("pointSubtotal", 0);
					lastParam.put("moneySubtotal", 0);
					lastParam.put("refundSubtotal", 0);
					lastParam.put("refundMoney", 0);
					lastParam.put("storeCode", storeCode);
					lastParam.put("SID", SID);
					lastParam.put("today", today);
					calcMapper.insertDayClose(lastParam);
				}
			}
			return today;
		}
		
		public Map<String, Object> getTodayList(String today, String sessionId) {
			Map<String, Object> storeInfo = calcMapper.getStoreInfo(sessionId);
			List<Map<String, Object>> getTodayTotal = calcMapper.getTodayTotal(today, sessionId);
			List<Map<String, Object>> getTodayList = calcMapper.getTodayList(today, sessionId);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			if(getTodayTotal.size() > 0) {
				Map<String, Object> todaytotal = getTodayTotal.get(getTodayTotal.size()-1);
				System.out.println("SUBTOTAL PRINT");
				System.out.println(todaytotal);
				resultMap.put("todaytotal", todaytotal);
				resultMap.put("getTodayList", getTodayList);
				resultMap.put("getTodayTotal", getTodayTotal);
				
			}
			resultMap.put("storeInfo", storeInfo);
			return resultMap;
		}
		
		public Map<String, Object> getCalcWait(int currentPage) {
			int startRow = 0;
			int rowPerPage = 10;
			int startPageNum = 1;
			int endPageNum = 10;
					
			//last 페이지 구하기
			double count = calcMapper.getCalcWaitCount();
			System.out.println(count + "<--- count");
			int lastPage = (int) Math.ceil(count/rowPerPage);
			System.out.println(lastPage + "<--- lastPage");
			
			//페이지 알고리즘
			startRow = (currentPage - 1) * rowPerPage;
			
			List<Map<String, Object>> calcWaitList = calcMapper.getCalcWait(startRow, rowPerPage);
			
			if(currentPage > 6 && lastPage < 10) {
				startPageNum = currentPage - 5;
				endPageNum  = currentPage + 4;
				
				if(endPageNum >= lastPage) {
					startPageNum = (lastPage - 9);
					endPageNum = lastPage;
				}
			}else {
				endPageNum = lastPage;
			}
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("lastPage", lastPage);
			resultMap.put("calcWaitList", calcWaitList);
			resultMap.put("startPageNum", startPageNum);
			resultMap.put("endPageNum", endPageNum);
			
			return resultMap;
		}

}
