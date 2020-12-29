package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.urban.spatium.dto.Item;
import com.urban.spatium.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
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
		
		List<Item> itemTotalLi = itemService.itemCountList();
		
		model.addAttribute("title", "장비 수량 목록");
		model.addAttribute("itemTotalLi", itemTotalLi);
		
		return "item/itemTotalAmount";
	}
	
	@GetMapping("/itemList")
	public String itemList(Model model) {
		
		List<Item> itemLi = itemService.itemList();
		
		model.addAttribute("title", "장비 목록");
		model.addAttribute("itemLi", itemLi);
		
		return "item/itemDetail";
	}
	
	@PostMapping("/addItem")
	public String addItem(Model model, Item item) {
			System.out.println(item + "=========== 장비 넘어온 값 ============");
			String result = itemService.addItem(item);
			System.out.println(result);
			
		return "redirect:/addItem";
	}
	
	@GetMapping("/addItem")
	public String addItem(Model model) {
		
		model.addAttribute("title", "장비 등록");
		
		return "item/itemBuyForm";
	}
	
}
