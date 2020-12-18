package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.item;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.okaySpace;


@Mapper
public interface RsvMapper {
	
	public void insertTbRsv(Rsv rsv);

	public List<Rsv> rsvList();
	
	public List<Rsv> rsvDetailList();
	
	public List<okaySpace> getSpaceByStore();
	
	public List<item> getItemByStore();
	
	
}
