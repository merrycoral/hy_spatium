package com.urban.spatium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class refundController {
	@GetMapping("/refundSearch")
	public String refundSearch(Model model) {
		
		
		model.addAttribute("title", "환불내역조회");
		return "refund/refundSearch";
	}
}
