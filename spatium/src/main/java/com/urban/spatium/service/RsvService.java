package com.urban.spatium.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.mapper.RsvMapper;


@Service
@Transactional
public class RsvService {
	// DI
	@Autowired 
	private RsvMapper rsvMapper;
	
	public void insertTbRsv(Rsv rsv) {
		//총 예약 시간 구하기
		
		int rsvTime = 0;
		String startTime = rsv.getStartTime()+":00:00";
		@SuppressWarnings("unused")
		String endTime = null;
		if(rsv.getEndTime()==null || rsv.getEndTime()=="") {
			rsvTime = 1;
			endTime=rsv.getStartTime()+":59:59";
		}else {
			endTime = rsv.getEndTime()+":59:59";
			int stime = Integer.parseInt(rsv.getStartTime());
			int etime = Integer.parseInt(rsv.getEndTime());
			rsvTime = etime-stime;
		}
		String rsvStartDateTime = rsv.getRsvDate().substring(0,10) + " " +startTime;
		String rsvEndDateTime = rsv.getRsvDate().substring(rsv.getRsvDate().length()-10,rsv.getRsvDate().length()) + " " +endTime;
		
		rsv.setRsvStartDateTime(rsvStartDateTime);
		rsv.setRsvEndDateTime(rsvEndDateTime);
		System.out.println(rsvStartDateTime + " <-- 예약 시작 일시");
		System.out.println(rsvEndDateTime + " <-- 예약 종료 일시");
		
		
		//예약 등록
		rsvMapper.insertTbRsv(rsv);
		int totalPrice = 0;
		int rsvCode = rsv.getRsvCode();
		if(rsv.getSpaceList() !=null) {
			for(int i=0; i<rsv.getSpaceList().size();i++) {	//공간 예약
				Map<String, Object> spaceRsv = rsv.getSpaceList().get(i);
				//가격 추가
				int spacePrice = Integer.valueOf(spaceRsv.get("spaceRentalPrice").toString());
				totalPrice = totalPrice + spacePrice;
				
				//공간 중복 체크
				//세부 공간 예약 등록
				rsvMapper.insertRsvSpaceDetail(spaceRsv);
				Object itemRsvCode = spaceRsv.get("rsvDetailCode");
				//릴레이션 등록
				rsvMapper.insertTbRsvRelation(rsvCode,itemRsvCode);
			}
		}
		if(rsv.getItemList() != null) {
			for(int i=0; i<rsv.getItemList().size();i++) {	//장비 예약
				Map<String, Object> itemRsv = rsv.getItemList().get(i);
				//가격 추가
				int itemPrice = Integer.valueOf(itemRsv.get("itemTotalPrice").toString());
				totalPrice = totalPrice + itemPrice;
				
				//세부 장비 예약 등록
				rsvMapper.insertRsvItemDetail(itemRsv);
				Object itemRsvCode = itemRsv.get("rsvDetailCode");
				
				//릴레이션 등록
				rsvMapper.insertTbRsvRelation(rsvCode,itemRsvCode);
				
			}
		}
		
		rsv.setRsvTotalPrice(totalPrice);
		System.out.println("총 시간당 예약 가격 --> "+totalPrice);
		
		//총 예약 가격은 시간당 예약가격 x 예약 시간
		totalPrice = totalPrice*(rsvTime);
		rsvMapper.updateRsvPrice(rsvCode, totalPrice);
	}

	public List<Rsv> rsvList() {
		List<Rsv> rsvList = rsvMapper.rsvList();
		return rsvList;
	}
	public List<Rsv> rsvDetailList() {
		List<Rsv> rsvDetailList = rsvMapper.rsvDetailList();
		return rsvDetailList;
	}

	public List<OKSpace> getSpaceByStore(int storeCode) {
		List<OKSpace> getSpaceByStore = rsvMapper.getSpaceByStore(storeCode);
		
		return getSpaceByStore;
	}

	public List<Item> getItemByStore(int storeCode) {
		List<Item> getItemByStore = rsvMapper.getItemByStore(storeCode);
		return getItemByStore;
	}

	public List<Rsv> rsvListExtend(String rsvCode) {
		List<Rsv> rsvListExtend = rsvMapper.rsvListExtend(rsvCode);
		return rsvListExtend;
	}

	public List<Rsv> getExRsv(Rsv rsv) {
		List<Rsv> getExRsv = rsvMapper.getExRsv(rsv);
		for(int i=0; i<getExRsv.size(); i++) {
			String startDT=getExRsv.get(i).getRsvStartDateTime();
			String endDt=getExRsv.get(i).getRsvEndDateTime();
			String startT = startDT.substring(11, 13);
			String endT = endDt.substring(11, 13);
			getExRsv.get(i).setStartTime(startT);
			getExRsv.get(i).setEndTime(endT);
		}
		
		return getExRsv;
	}
	
	/**
	 * 그 시간대 장비 현황 파악 메서드
	 */
	public List<Rsv> getExItemRsv(Rsv rsv) {
		rsv.getRsvDate();
		rsv.getStartTime();
		rsv.getEndTime();
		
		rsv.setRsvStartDateTime(rsv.getRsvDate() +" "+ rsv.getStartTime() + ":00:00");
		rsv.setRsvEndDateTime(rsv.getRsvDate() +" "+ rsv.getEndTime() + ":00:00");
		
		List<Rsv> getExItemRsv = rsvMapper.getExItemRsv(rsv);
		return getExItemRsv;
	}

	public void cancelRsv(int rsvCode) {
		List<String> rsvDetailList = rsvMapper.getRsvDetailCodeByRsvCode(rsvCode);
		rsvMapper.cancelRsvRelation(rsvCode);
		rsvMapper.cancelRsv(rsvCode);
		rsvMapper.cancelRsvDetail(rsvDetailList);
		System.out.println("삭제완료");
		
	}
	
	
	
	

}
