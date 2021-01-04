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
		Store updateStore = storeMapper.getStoreInfoByStoreCode(storeCode);
		return updateStore;
	}
	
	public Store getStoreInfoByStoreCode(int storeCode) {
			Store getStoreInfoByStoreCode = storeMapper.getStoreInfoByStoreCode(storeCode);
			getStoreInfoByStoreCode.setStoreIntroduction(getStoreInfoByStoreCode.getStoreIntroduction().replaceAll("\r\n", "<br>"));
		return getStoreInfoByStoreCode;
	}
	
	public String addStore(Store store, Map<String, Object> storeMap) {
		String insertCheck = "업체 등록 실패";
		
		
		if(store != null) {
			int result = storeMapper.addStore(store);
			int storeCode = store.getStoreCode();
			
			storeMapper.addStoreRelation(storeMap);
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

	public List<Map<String, Object>> getRefundRuleByStoreCode(int storeCode) {
		List<Map<String, Object>> refundRule = storeMapper.getRefundRuleByStoreCode(storeCode);
		return refundRule;
	}

}
