package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.mapper.SpaceMapper;

@Service
@Transactional
public class SpaceService {
	
	@Autowired
	private SpaceMapper spaceMapper;
	
	public List<ReadySpace> readySpaceList(){
		
		List<ReadySpace> readySpaceList = spaceMapper.readySpaceList();
		
		return readySpaceList;
	}
	
	public List<OKSpace> OKSpaceList(){
		
		List<OKSpace> OKSpaceList = spaceMapper.OKSpaceList();
		
		return OKSpaceList;
	}
}
