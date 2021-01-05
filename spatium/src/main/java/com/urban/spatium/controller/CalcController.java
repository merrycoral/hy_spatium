package com.urban.spatium.controller;

import java.util.List;

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
		public String adminCalc(Model model, @RequestParam(name="result", required = false) String result) {
			List<CalcWait> calcWaitList = calcService.getCalcWait();
			model.addAttribute("calcWaitList", calcWaitList);
			return "calculate/adminCalc";
		}
		@GetMapping("/sellerCalc")
		public String sellerCalc(Model model, @RequestParam(name="result", required = false) String result) {
			return "calculate/sellerCalc";
		}
		
}
