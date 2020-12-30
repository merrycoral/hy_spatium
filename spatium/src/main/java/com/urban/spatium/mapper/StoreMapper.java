package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Store;

@Mapper
public interface StoreMapper {
	
	public int updateStoreSet(Store store);
	
	public Store updateStore(int storeCode);
	
	public List<Store> getByStoreCateCode(int storeCode);
	
	public List<Store> addStoreRelation(int storeCode);
	
	public int addStore(Store store);
	
	public List<Store> storeList();
	
}
