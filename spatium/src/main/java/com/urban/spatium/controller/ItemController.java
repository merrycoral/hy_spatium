package com.urban.spatium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	@GetMapping("/itemCountList")
	public String itemCountList(Model model) {
		
		model.addAttribute("title", "장비 수량 목록");
		
		return "item/itemTotalAmount";
	}
	
	@GetMapping("/itemList")
	public String itemList(Model model) {
		
		model.addAttribute("title", "장비 목록");
		
		return "item/itemDetail";
	}
	
	@GetMapping("/addItem")
	public String addItem(Model model) {
		
		model.addAttribute("title", "장비 등록");
		
		return "item/itemBuyForm";
	}
	
}
