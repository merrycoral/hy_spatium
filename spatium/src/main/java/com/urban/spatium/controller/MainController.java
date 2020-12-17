package com.urban.spatium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.urban.spatium.service.AccessService;

@Controller
public class MainController {
	
	@Autowired
	private AccessService accessService;
	
	
	@GetMapping("/admin")
	public String admin() {
		return "main";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/writeReview")
	public String writeReview() {
		return "review/writeReview";
	}
	
	@GetMapping("/statistic")
	public String statisticEx() {
		return "statistic/statisticEx";
	}
	
}
