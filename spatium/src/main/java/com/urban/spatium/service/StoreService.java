package com.urban.spatium.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Store;
import com.urban.spatium.mapper.StoreMapper;

@Service
@Transactional
public class StoreService {
	
	@Autowired
	private StoreMapper storeMapper;
	
	public String updateStoreSet(Store store) {
		
		String updateCheck = "업체 수정 실패";
		
		if(store != null) {
			updateCheck = "업체 수정 성공";
			storeMapper.updateStoreSet(store);
		}
			
		return updateCheck;
	}
	
	public Store updateStore(int storeCode) {
		
			Store updateStore = storeMapper.updateStore(storeCode);
			
		return updateStore;
	}
	
	public String addStore(Store store) {
		String insertCheck = "업체 등록 실패";
		
		
		if(store != null) {
			int result = storeMapper.addStore(store);
			int storeCode = store.getStoreCode();
			Map<String, Object> spaceRelationCateCodeMap = store.getSpaceRelationCateCodeMap();
			
			storeMapper.addStoreRelation(storeCode);
			if(result > 0) {
				insertCheck = "업체 등록 성공";
			}
		}
		
		return insertCheck;
	}
	
	public List<Store> storeList(){
		
		List<Store> storeList = storeMapper.storeList();
		
		return storeList;
	}
}
