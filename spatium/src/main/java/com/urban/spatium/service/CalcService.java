package com.urban.spatium.service;

import java.util.ArrayList;
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
		
		public String CloseCalc(String today){
			//업체 id 목록 가져오기
			List<Map<String, String>> storeIdList = calcMapper.getStoreIdList();
			System.out.println("PRINT storeIdList");
			System.out.println(storeIdList);
			for(int i=0; i<storeIdList.size();i++) {
				String storeCode = storeIdList.get(i).get("storeCode");
				String SID = storeIdList.get(i).get("storeId");
				
				List<Map<String, Object>> getTodaySubtotal = calcMapper.getTodaySubtotal(today, SID);
				Map<String, Object> subtotal = getTodaySubtotal.get(getTodaySubtotal.size()-1);
			}
			
			return today;
		}
		
		public Map<String, Object> getTodayList(String today, String sessionId) {
			int startPageNum = 1;
			int endPageNum = 10;
			String SID = sessionId;
			
			List<Map<String, Object>> getTodaySubtotal = calcMapper.getTodaySubtotal(today, SID);
			Map<String, Object> subtotal = getTodaySubtotal.get(getTodaySubtotal.size()-1);
			System.out.println("SUBTOTAL PRINT");
			System.out.println(subtotal);
			
			List<Map<String, Object>> getTodayList = calcMapper.getTodayList(today, SID);
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("getTodayList", getTodayList);
			resultMap.put("getTodaySubtotal", getTodaySubtotal);
			resultMap.put("subtotal", subtotal);
			resultMap.put("startPageNum", startPageNum);
			resultMap.put("endPageNum", endPageNum);
			
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
