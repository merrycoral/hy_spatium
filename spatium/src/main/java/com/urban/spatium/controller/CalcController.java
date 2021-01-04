package com.urban.spatium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CalcController {
		
		@GetMapping("/adminCalc")
		public String adminCalc(Model model, @RequestParam(name="result", required = false) String result) {
			return "calculate/adminCalc";
		}
		@GetMapping("/sellerCalc")
		public String sellerCalc(Model model, @RequestParam(name="result", required = false) String result) {
			return "calculate/sellerCalc";
		}
		
}
