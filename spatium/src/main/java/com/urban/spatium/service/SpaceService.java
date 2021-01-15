package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.dto.Store;
import com.urban.spatium.mapper.SpaceMapper;

@Service
@Transactional
public class SpaceService {
	
	@Autowired
	private SpaceMapper spaceMapper;
	
	public String OKSpaceInsert(String readySpaceId, String readySpaceCode) {
		String chk = "삽입";
		
		spaceMapper.OKSpaceInsert(readySpaceId, readySpaceCode);
		
		return chk;
	}
	
	public String readySpaceDelete(String readySpaceCode) {
		String chk = "삭제";
		spaceMapper.readySpaceDelete(readySpaceCode);
		
		return chk;
	}
	
	public List<ReadySpace> readySpaceAccept(int readySpaceCode){
	
		List<ReadySpace> rsl = spaceMapper.readySpaceAccept(readySpaceCode);
		
		return rsl;
	}
	
	public List<Store> addSpaceChoice(String storeId){
		
			List<Store> spaceChoiceList = spaceMapper.addSpaceChoice(storeId);
		
		return spaceChoiceList;
	}
	
	public String addSpace(String storeCode){
		
		
		String okSpaceCate = spaceMapper.addSpace(storeCode);
		
		return okSpaceCate;
		
	}
	
	public String addReadySpace(ReadySpace readySpace, String storeCode) {
		int result = spaceMapper.addReadySpace(readySpace);
		
		String checkCate = "ㅎㅇ";
		
		System.out.println(storeCode + "애드레디스페이스11111111111111111111111");
		
		return checkCate;
	}
	
	public List<ReadySpace> readySpaceList(){
		
		List<ReadySpace> readySpaceList = spaceMapper.readySpaceList();
		
		return readySpaceList;
	}
	
	public List<OKSpace> OKSpaceList(){
			
		List<OKSpace> OKSpaceList = spaceMapper.OKSpaceList();
		
		return OKSpaceList;
	}
	
	public List<OKSpace> OKSpaceListByStoreCode(int storeCode){
		
		List<OKSpace> OKSpaceListByStoreCode = spaceMapper.OKSpaceListByStoreCode(storeCode);
		//업체 세부 소개의 띄어쓰기 <br>로 변환
		for(int i=0; i<OKSpaceListByStoreCode.size(); i++) {
			OKSpaceListByStoreCode.get(i).setOkayDetailSpace(OKSpaceListByStoreCode.get(i).getOkayDetailSpace().replaceAll("\r\n", "<br>"));
		}
		return OKSpaceListByStoreCode;
	}
	
}
