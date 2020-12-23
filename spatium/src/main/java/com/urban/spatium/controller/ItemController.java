package com.urban.spatium.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	
	@GetMapping("/itemBuyList")
	public String itemBuyList(Model model) {
		
		model.addAttribute("title", "장비 구입");
		
		return "item/itemBuyList";
	}
	
	@GetMapping("/itemRepairList")
	public String itemRepairList(Model model) {
		
		model.addAttribute("title", "장비 수리");
		
		return "item/itemRepairList";
	}
	
	@GetMapping("/itemDeleteList")
	public String itemDeleteList(Model model) {
		
		model.addAttribute("title", "장비 파기");
		
		return "item/itemDeleteList";
	}
	
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
	
	@GetMapping("/adddItem")
	public String addItem(Model model) {
		
		model.addAttribute("title", "장비 등록");
		
		return "item/itemBuyForm";
	}
	
}
