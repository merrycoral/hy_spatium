package com.urban.spatium.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.urban.spatium.dto.CalcWait;


public interface CalcMapper {

	List<Map<String, Object>> getCalcWait(int startRow, int rowPerPage);

	int getCalcWaitCount();

	int getTodayCount(String today);

	List<Map<String, Object>> getTodayList(String today, String sID);

	List<Map<String, Object>> getTodaySubtotal(String today, String sID);

	List<Map<String, String>> getStoreIdList();

}
