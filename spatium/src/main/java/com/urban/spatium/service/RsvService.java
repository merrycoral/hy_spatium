package com.urban.spatium.service;

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
		
		String startTime = rsv.getStartTime();
		String endTime = rsv.getEndTime();
		String rsvStartDateTime = rsv.getRsvDate() + " " +startTime;
		String rsvEndDateTime = rsv.getRsvDate() + " " +endTime;
		rsv.setRsvStartDateTime(rsvStartDateTime);
		rsv.setRsvEndDateTime(rsvEndDateTime);
		System.out.println(rsvStartDateTime + " <-- 예약 시작 일시");
		System.out.println(rsvEndDateTime + " <-- 예약 종료 일시");
		//예약 등록
		rsvMapper.insertTbRsv(rsv);
		int totalPrice = 0;
		int rsvCode = rsv.getRsvCode();
		
		for(int i=0; i<rsv.getSpaceList().size();i++) {	//공간 예약
			Map<String, Object> spaceRsv = rsv.getSpaceList().get(i);
			//가격 추가
			int spacePrice = Integer.valueOf(spaceRsv.get("spaceRentalPrice").toString());
			totalPrice = totalPrice + spacePrice;
			
			//세부 공간 예약 등록
			rsvMapper.insertRsvSpaceDetail(spaceRsv);
			Object itemRsvCode = spaceRsv.get("rsvDetailCode");
			
			//릴레이션 등록
			rsvMapper.insertTbRsvRelation(rsvCode,itemRsvCode);
		}
		
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
		
		rsv.setRsvTotalPrice(totalPrice);
		System.out.println("총 시간당 예약 가격 --> "+totalPrice);
		
		//총 예약 가격 업데이트
		int startT = Integer.parseInt(startTime);
		int endT = Integer.parseInt(endTime);
		//총 예약 가격은 시간당 예약가격 x 예약 시간
		totalPrice = totalPrice*(endT-startT);
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

	public List<OKSpace> getSpaceByStore() {
		List<OKSpace> getSpaceByStore = rsvMapper.getSpaceByStore();
		
		return getSpaceByStore;
	}

	public List<Item> getItemByStore() {
		List<Item> getItemByStore = rsvMapper.getItemByStore();
		return getItemByStore;
	}

	public List<Rsv> rsvListExtend(String rsvCode) {
		List<Rsv> rsvListExtend = rsvMapper.rsvListExtend(rsvCode);
		return rsvListExtend;
	}
	
	
	
	

}
