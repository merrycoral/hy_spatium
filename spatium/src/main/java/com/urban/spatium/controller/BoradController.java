package com.urban.spatium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.urban.spatium.service.AccessService;

@Controller
public class BoradController {
	
	@Autowired
	private AccessService accessService;
	
	@GetMapping("/boardList")
	public String boardList() {
		return "borad/boardList";
	}
	
	@GetMapping("/boardArticleList")
	public String boardArticleList() {
		return "borad/boardArticleList";
	}
	
	@GetMapping("/faqList")
	public String faqList() {
		return "borad/faqList";
	}
	

	
	
}
