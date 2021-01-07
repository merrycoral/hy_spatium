package com.urban.spatium.service;

import java.util.ArrayList;
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
	
	public String addSpace(String okId){
	
		String okSpaceCate = spaceMapper.addSpace(okId);
		
		return okSpaceCate;
		
	}
	
	public String addReadySpace(ReadySpace readySpace) {
		int result = spaceMapper.addReadySpace(readySpace);
		String insertCheck = "공간 등록 실패";
		
		if(result > 0) {
			insertCheck = "공간 등록 성공";
		}
		
		return insertCheck;
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
