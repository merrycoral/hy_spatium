package com.urban.spatium.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;

@Mapper
public interface SpaceMapper {
	
	public int addReadySpace(ReadySpace readySpace);
	
	public List<ReadySpace> readySpaceList();
	
	public List<OKSpace> OKSpaceList();

	public List<OKSpace> OKSpaceListByStoreCode(int storeCode);
	
}
