package com.urban.spatium.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.urban.spatium.dto.CalcWait;


public interface CalcMapper {

	int CalcDailyDelete(String storeCode);
	
	List<Map<String, Object>> getCalcWait(int startRow, int rowPerPage);

	int getCalcWaitCount();

	int getTodayCount(String storeCode, String today);

	List<Map<String, Object>> getTodayList(String today, String SID);

	List<Map<String, Object>> getStoreIdList();

	List<Map<String, Object>> getTodayTotal(String today, String SID);

	void insertDayClose(Map<String, Object> lastParam);

	List<Map<String, Object>> getDailyCalc(String sessionId, int sessionLevel);

	Map<String, Object> getStoreInfo(String sessionId);

}
