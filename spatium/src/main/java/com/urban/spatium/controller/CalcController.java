package com.urban.spatium.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.CalcWait;
import com.urban.spatium.service.CalcService;


@Controller
public class CalcController {
		@Autowired
		private CalcService calcService;
		
		@GetMapping("/currentCalc")
		public String currentCalc(HttpSession session, Model model, @RequestParam(name="result", required = false) String result
				, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
			//String today = day.format(cal.getTime());
			String today = "2021-01-10";
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
			String nowtime = time.format(cal.getTime());
			System.out.println(today);
			System.out.println(nowtime);
			
			String sessionId = (String) session.getAttribute("SID");
			Map<String, Object> resultMap = calcService.getTodayList(today, sessionId);
			calcService.CloseCalc("2021-01-11");
			
			model.addAttribute("title", "실시간 매출 현황");
			model.addAttribute("today", today);
			model.addAttribute("getTodayList", resultMap.get("getTodayList"));
			model.addAttribute("subtotal", resultMap.get("subtotal"));
			
			return "calculate/currentCalc";
		}
		
		@GetMapping("/dailyCalc")
		public String dailyCalc(Model model, @RequestParam(name="result", required = false) String result
					, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
			String today = day.format(cal.getTime());
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
			String nowtime = time.format(cal.getTime());
			System.out.println(today);
			System.out.println(nowtime);
			
			return "calculate/dailyCalc";
		}
		@GetMapping("/adminCalc")
		public String adminCalc(Model model, @RequestParam(name="result", required = false) String result
				, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
			Map<String, Object> resultMap = calcService.getCalcWait(currentPage);
			
			model.addAttribute("title", "리뷰 전체 조회");
			model.addAttribute("calcWaitList", resultMap.get("calcWaitList"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			return "calculate/adminCalc";
		}
		
		@GetMapping("/sellerCalc")
		public String sellerCalc(Model model, @RequestParam(name="result", required = false) String result) {
			return "calculate/sellerCalc";
		}
		
}
