package com.urban.spatium.mapper;

import java.util.List;
import java.util.Map;

import com.urban.spatium.dto.CalcWait;

public interface CalcMapper {

	List<Map<String, Object>> getCalcWait(int startRow, int rowPerPage);

	int getCalcWaitCount();

}
