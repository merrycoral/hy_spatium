package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Store;

@Mapper
public interface StoreMapper {
	
	public List<Store> myStoreList(String storeId);
	
	public List<Store> mainSearchAll(String searchName);
	
	public int updateStoreSet(Store store);
	
	public Store getStoreInfoByStoreCode(int storeCode);
	
	public int addStoreRelation(List<Map<String, Object>> storeMap);
	
	public int addStore(Store store);
	
	public List<Store> storeList();

	public List<Store> bestStoreList();
	
	public List<Map<String, Object>> getRefundRuleByStoreCode(int storeCode);

	public void addBestStore(String storeCode);

	public void delBestStore(String storeCode);

}
