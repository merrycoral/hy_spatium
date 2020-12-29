package com.urban.spatium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/admin")
	public String admin() {
		return "main";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
