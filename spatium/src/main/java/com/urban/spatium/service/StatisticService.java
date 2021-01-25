package com.urban.spatium.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.mapper.StatisticMapper;

@Service
@Transactional
public class StatisticService {
	@Autowired
	private StatisticMapper statisticMapper;

	public List<Map <String, Object>> getDailyRsv(String SID){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String today = day.format(cal.getTime());
		List<Map <String, Object>> latest7days = statisticMapper.getDailyRsv(SID);
		System.out.println(latest7days);
		return latest7days;
	}
}
