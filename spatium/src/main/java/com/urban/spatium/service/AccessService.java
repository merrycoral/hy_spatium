package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Access;
import com.urban.spatium.dto.Browser4;
import com.urban.spatium.mapper.AccessMapper;

@Service
@Transactional
public class AccessService {
		@Autowired
		private AccessMapper accessMapper;

		public void getBrowserTop4(){
			List<Browser4> browser4 = accessMapper.getBrowserTop4();
			System.out.println(browser4);
			String btop1 = browser4.get(0).getBrowserName();
			String btop2 = browser4.get(1).getBrowserName();
			String btop3 = browser4.get(2).getBrowserName();
			String btop4 = browser4.get(3).getBrowserName();
			int etcBroswer = accessMapper.getEtcAccess(btop1, btop2, btop3, btop4);
			//browser4.add()
		}
		
		public int[] getAccessCount() {
			int[] accessCount = new int[2];
			accessCount[0] = accessMapper.getTotalAccess();
			return accessCount;
		}
		
		public List<Access> getAccessRecord() {
			List<Access> accessList = accessMapper.getAccessRecord();
			return accessList;
		}
	
	
}
