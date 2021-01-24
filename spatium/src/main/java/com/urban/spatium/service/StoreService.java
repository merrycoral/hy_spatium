package com.urban.spatium.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.RefundPolicy;
import com.urban.spatium.dto.Store;
import com.urban.spatium.mapper.RefundMapper;
import com.urban.spatium.mapper.StoreMapper;

@Service
@Transactional
public class StoreService {
	
	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private RefundMapper refundMapper;
	
	public List<Store> myStoreList(String storeId){
		
		List<Store> myStoreList =  storeMapper.myStoreList(storeId);
		
		return myStoreList;
	}
	
	public List<Store> mainSearchAll(String searchName){
			
			List<Store> searchStore = storeMapper.mainSearchAll(searchName);
		
		return searchStore;
	}
	
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
	
	public String addStore(Store store, List<String> tList,RefundPolicy refundPolicy) {
		String insertCheck = "업체 등록 실패";
		
		if(store != null) {
			int result = storeMapper.addStore(store);
			
			int StoreCode = store.getStoreCode();
			System.out.println(StoreCode + "스토어코드asdasdasd");
			
			int refundPolicyCode = refundPolicy.getRefundPolicyCode();
			System.out.println(refundPolicyCode + "리파운드폴링키코드asdasdasd");
			
			
			
			for(int i=0; i<store.getRemainingDay().size();i++) {
				store.setRefundPercents(store.getRefundPercent().get(i));
				store.setRemainingDays(store.getRemainingDay().get(i));
				refundMapper.addRefundPolicy(store);
				refundMapper.addRefundPolicyRelation(store);
			}
			
			System.out.println(tList);
			
			List<Map<String, Object>> storeListMap = new ArrayList<Map<String, Object>>();;
			for(int i=0; i<tList.size(); i++) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("code", StoreCode);
				map.put("cateNumber", tList.get(i));
				System.out.println(map + "리스트에 들어갈것");
				storeListMap.add(map);
				System.out.println(storeListMap + " 들어간후의 리스트");
			}
			System.out.println(storeListMap + "최종 리스트");
			storeMapper.addStoreRelation(storeListMap);
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

	public void addBestStore(String storeCode) {
		storeMapper.addBestStore(storeCode);
	}

	public List<Store> bestStoreList() {
		List<Store> bestStoreList = storeMapper.bestStoreList();
		return bestStoreList;
	}

	public void delBestStore(String storeCode) {
		storeMapper.delBestStore(storeCode);
	}

}
