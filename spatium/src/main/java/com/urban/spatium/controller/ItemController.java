package com.urban.spatium.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Item;
import com.urban.spatium.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	
	
	@GetMapping("/itemInfo")
	public String itemInfo(Model model, Item item
							,@RequestParam(name = "storeItemCode", required = false) int storeItemCode) {
		
			model.addAttribute("title", "장비 상세 정보");
			model.addAttribute("item", item);
			
		return "item/itemInfo";
	}
	
	//장비구입내역
	@GetMapping("/itemBuyList")
	public String itemBuyList(Model model) {
		
		model.addAttribute("title", "장비 구입");
		
		return "item/itemBuyList";
	}
	
	//장비수리내역
	@GetMapping("/itemRepairList")
	public String itemRepairList(Model model) {
		
		model.addAttribute("title", "장비 수리");
		
		return "item/itemRepairList";
	}
	
	//장비파기내역
	@GetMapping("/itemDeleteList")
	public String itemDeleteList(Model model) {
		
		model.addAttribute("title", "장비 파기");
		
		return "item/itemDeleteList";
	}
	
	//장비수량목록
	@GetMapping("/itemCountList")
	public String itemCountList(Model model) {
		
		List<Item> itemTotalLi = itemService.itemCountList();
		
		model.addAttribute("title", "장비 수량 목록");
		model.addAttribute("itemTotalLi", itemTotalLi);
		
		return "item/itemTotalAmount";
	}
	
	//장비목록
	@GetMapping("/itemList")
	public String itemList(Model model) {
		
		List<Item> itemLi = itemService.itemList();
		
		model.addAttribute("title", "장비 목록");
		model.addAttribute("itemLi", itemLi);
		
		return "item/itemDetail";
	}
	
	//장비등록
	@PostMapping("/addItem")
	public String addItem(Model model, Item item) {
			System.out.println(item + "=========== 장비 넘어온 값 ============");
			String result = itemService.addItem(item);
			item.getItemDetailCode();
			item.setItemDetailCode(item.getItemCode());
			System.out.println(result);
			
		return "redirect:/addItem";
	}
	
	@GetMapping("/addItem")
	public String addItem(Model model) {
		
		model.addAttribute("title", "장비 등록");
		
		return "item/itemBuyForm";
	}
	
}
