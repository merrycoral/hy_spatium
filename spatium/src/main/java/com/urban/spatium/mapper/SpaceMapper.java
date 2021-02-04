package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.dto.Store;

@Mapper
public interface SpaceMapper {
	
	public int spaceOKDelete(String storeCode);
	
	public int spaceReadyDelete(String storeCode);
	
	public int spaceRelationDelet(String storeCode);
	
	public List<OKSpace> myOKSpaceList(String okaySpaceId);
	
	public List<ReadySpace> myReadySpaceList(String readySpaceId);
	
	public int OKSpaceInsert (String readySpaceId, String readySpaceCode);
	
	public int readySpaceDelete (String readySpaceCode);
	
	public List<ReadySpace> readySpaceAccept(int readySpaceCode);
	
	public List<Store> addSpaceChoice(String storeId);
	
	public String addSpace(String storeCode);
	
	public int addReadySpace(ReadySpace readySpace);
	
	public List<ReadySpace> readySpaceList();
	
	public List<OKSpace> OKSpaceList();

	public List<OKSpace> OKSpaceListByStoreCode(int storeCode);
	
}
