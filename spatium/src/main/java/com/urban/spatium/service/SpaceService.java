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
	
	public List<Store> addSpaceChoice(String storeId){
		
			List<Store> spaceChoiceList = spaceMapper.addSpaceChoice(storeId);
		
		return spaceChoiceList;
	}
	
	public String addSpace(String storeCode){
		
		
		String okSpaceCate = spaceMapper.addSpace(storeCode);
		
		return okSpaceCate;
		
	}
	
	public List<String> addReadySpace(ReadySpace readySpace, String storeCode) {
		int result = spaceMapper.addReadySpace(readySpace);
		
		String storeCate = readySpace.getReadyStoreBusinessType();
		
		List<String> tMap = new ArrayList<>();
		
		String[] array = storeCate.split(",");
		String[] i_array = new String[5];
		String arrayCheck = "0";
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
			
			if(array[i].equals("촬영 스튜디오")) {
				arrayCheck = "1";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("엠티장소")) {
				arrayCheck = "2";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("스터디룸")) {
				arrayCheck = "3";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("연습실")) {
				arrayCheck = "4";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("파티룸")) {
				arrayCheck = "5";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("회의실")) {
				arrayCheck = "6";	
				i_array[i]=arrayCheck;
			}else if(array[i].equals("카페")) {
				arrayCheck = "7";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("다목적홀")) {
				arrayCheck = "8";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("공연장")) {
				arrayCheck = "9";
				i_array[i]=arrayCheck;
			}else if(array[i].equals("한옥")) {
				arrayCheck = "10";
				i_array[i]=arrayCheck;
			}
			System.out.println(arrayCheck + "arrayCheck 숫자");
			System.out.println(i_array[i] + "넣을 카테고리");
			tMap.add(i, i_array[i]);
		}
		
		System.out.println(tMap);
		
		System.out.println(storeCode + "애드레디스페이스11111111111111111111111");
		
		return tMap;
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
