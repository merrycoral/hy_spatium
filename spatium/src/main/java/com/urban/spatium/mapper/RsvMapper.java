package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Rsv;


@Mapper
public interface RsvMapper {
	
	public void insertTbRsv(Rsv rsv);

	public List<Rsv> rsvList();
	
	
}
