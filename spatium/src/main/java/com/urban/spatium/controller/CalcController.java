package com.urban.spatium.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.URLgetter;
import com.urban.spatium.dto.CalcWait;
import com.urban.spatium.service.CalcService;


@Controller
public class CalcController {
		@Autowired
		private CalcService calcService;
		
		@GetMapping("/currentCalc")
		public String currentCalc(HttpSession session, Model model, @RequestParam(name="result", required = false) String result
				) {
			String sessionId = (String) session.getAttribute("SID");
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
			String today = day.format(cal.getTime());
			SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
			String nowtime = time.format(cal.getTime());
			System.out.println(today);
			System.out.println(nowtime + " <- nowtime");
			
			Map<String, Object> resultMap = calcService.getTodayList(today, sessionId);
			System.out.println(resultMap.get("getTodayList"));
			model.addAttribute("title", "실시간 매출 현황");
			model.addAttribute("today", today);
			model.addAttribute("nowtime", nowtime);
			model.addAttribute("storeInfo", resultMap.get("storeInfo"));
			model.addAttribute("getTodayList", resultMap.get("getTodayList"));
			model.addAttribute("todaytotal", resultMap.get("todaytotal"));
			return "calculate/currentCalc";
		}
		
		@GetMapping("/dailyCalcSeeMore")
		public String dailyCalcSeeMore(Model model, HttpServletRequest request, HttpSession session) {
			String sessionId = (String) session.getAttribute("SID");
			System.out.println(URLgetter.getURL(request));
			String[] array = URLgetter.getURL(request).split("=");
			String getDate = array[1];
			
			Map<String, Object> resultMap = calcService.getTodayList(getDate, sessionId);
			
			model.addAttribute("title", getDate + "매출 내역");
			model.addAttribute("getDate", getDate);
			model.addAttribute("getTodayList", resultMap.get("getTodayList"));
			model.addAttribute("todaytotal", resultMap.get("todaytotal"));
			model.addAttribute("storeInfo", resultMap.get("storeInfo"));
			return "calculate/dailyCalcSeeMore";
		}
		
		@GetMapping("/dailyCalc")
		public String dailyCalc(HttpSession session, Model model, @RequestParam(name="result", required = false) String result
					) {
			String sessionId = (String) session.getAttribute("SID");
			int sessionLevel = Integer.parseInt(session.getAttribute("SLEVEL").toString());
			System.out.println(sessionLevel);
			Map<String, Object> resultMap = calcService.getDailyCalc(sessionId, sessionLevel);
			System.out.println("======== print dailyCalcList =========");
			System.out.println(resultMap.get("dailyCalcList"));
			
			model.addAttribute("sessionLevel", sessionLevel);
			model.addAttribute("dailyCalcList", resultMap.get("dailyCalcList"));
			model.addAttribute("storeInfo", resultMap.get("storeInfo"));
			
			return "calculate/dailyCalc";
		}
		@GetMapping("/adminCalc")
		public String adminCalc(Model model, @RequestParam(name="result", required = false) String result
				, @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage) {
		
			Map<String, Object> resultMap = calcService.getCalcWait(currentPage);
			
			model.addAttribute("title", "관리자 정산 조회");
			model.addAttribute("calcWaitList", resultMap.get("calcWaitList"));
			model.addAttribute("lastPage", resultMap.get("lastPage"));
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("startPageNum", resultMap.get("startPageNum"));
			model.addAttribute("endPageNum", resultMap.get("endPageNum"));
			return "calculate/adminCalc";
		}
		
		@GetMapping("/sellerCalc")
		public String sellerCalc(Model model, @RequestParam(name="result", required = false) String result,  HttpSession session) {
			String sessionId = (String) session.getAttribute("SID");
			
			return "calculate/sellerCalc";
		}
		
}
