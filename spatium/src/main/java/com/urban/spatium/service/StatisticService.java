package com.urban.spatium.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.mapper.CalcMapper;
import com.urban.spatium.mapper.StatisticMapper;

@Service
@Transactional
public class StatisticService {
	@Autowired
	private StatisticMapper statisticMapper;
	@Autowired
	private CalcMapper calcMapper;

	public List<Map <String, Object>> getDailyRsv(String SID){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String today = day.format(cal.getTime());
		List<Map <String, Object>> latest7days = statisticMapper.getDailyRsv(SID);
		
		System.out.println(latest7days);
		return latest7days;
	}
	public Map <String, Object> statGenderJob(String SID){
		Map<String, Object> storeInfo = calcMapper.getStoreInfo(SID);
		String storeCode = Integer.toString((Integer)storeInfo.get("storeCode"));
		List<Map <String, Object>> getByGender = statisticMapper.statGenderJob(storeCode, "userGender");
		List<Map <String, Object>> getByJob = statisticMapper.statGenderJob(storeCode, "userJob");
		List<Map <String, Object>> getByAge = statisticMapper.statAge(storeCode);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("getByGender", getByGender);
		resultMap.put("getByJob", getByJob);
		resultMap.put("getByAge", getByAge);
		
		return resultMap;
	}
}
