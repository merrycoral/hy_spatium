package com.urban.spatium.service;

import java.util.HashMap;
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
		
		
		String rsvStartDateTime = rsv.getRsvDate() + " " +rsv.getStartTime();
		String rsvEndDateTime = rsv.getRsvDate() + " " +rsv.getEndTime();
		rsv.setRsvStartDateTime(rsvStartDateTime);
		rsv.setRsvEndDateTime(rsvEndDateTime);
		System.out.println(rsvStartDateTime + " <-- 예약 시작 일시");
		System.out.println(rsvEndDateTime + " <-- 예약 종료 일시");
		
		
		rsvMapper.insertRsvItemDetail(rsv);
		rsvMapper.insertRsvSpaceDetail(rsv);
		rsvMapper.insertTbRsv(rsv);
		
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
	
	
	
	

}
