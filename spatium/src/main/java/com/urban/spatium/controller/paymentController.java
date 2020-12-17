package com.urban.spatium.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class paymentController {

	@GetMapping("/paymentSearch")
	public String paymentSearch(Model model) {
		
		
		model.addAttribute("title", "결제내역조회");
		return "payment/paymentSearch";
	}
	
	@GetMapping("/pointSearch")
	public String pointSearch(Model model) {
		
		
		model.addAttribute("title", "마일리지 사용내역 조회");
		return "point/pointSearch";
	}
}
