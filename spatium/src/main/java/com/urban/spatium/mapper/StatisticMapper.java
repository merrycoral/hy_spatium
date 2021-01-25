package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatisticMapper {

	List<Map<String, Object>> getDailyRsv(String SID);

}
