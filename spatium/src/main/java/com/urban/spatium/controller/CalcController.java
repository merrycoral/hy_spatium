package com.urban.spatium.controller;

import java.util.List;
import java.util.Map;

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
