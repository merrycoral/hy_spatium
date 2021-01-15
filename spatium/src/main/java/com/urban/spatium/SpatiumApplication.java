package com.urban.spatium;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.urban.spatium.service.CalcService;

@SpringBootApplication
@EnableScheduling
public class SpatiumApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpatiumApplication.class, args);
	}
	
	@Autowired
	private CalcService calcService;
	@Scheduled(cron = "0 0 0 * * ?")
	public void scheduledClose() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		String today = day.format(cal.getTime());
		calcService.CloseCalc(today);
	}

}
