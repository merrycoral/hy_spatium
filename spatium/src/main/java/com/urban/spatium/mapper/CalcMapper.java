package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;


public interface CalcMapper {

	List<Map<String, Object>> getCalcWait(int startRow, int rowPerPage);

	int getCalcWaitCount();

	int getTodayCount(String today);

	List<Map<String, Object>> getTodayList(String today);

	List<Map<String, Object>> getTodaySubtotal(String today);

}
