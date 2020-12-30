package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.urban.spatium.dto.Store;
import com.urban.spatium.service.StoreService;


@Controller
public class MainController {
	@Autowired 
	private StoreService storeService; 
	
	@GetMapping("/admin")
	public String admin() {
		return "main";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("storeList", storeList);
		return "index";
	}
	
	@GetMapping("/storeInfo")
	public String storeInfo(Model model, int storeCode) {
		model.addAttribute("storeCode", storeCode);
		return "store/storeInfo";
	}
	
}
