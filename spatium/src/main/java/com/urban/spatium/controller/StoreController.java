package com.urban.spatium.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Store;
import com.urban.spatium.service.StoreService;

@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;

	@PostMapping("/addStore")
	public String addStore(Model model, Store store) {
		
		System.out.println(store);
		store.getStoreCode();
		store.getSpaceRelationCateCode();
		System.out.println("===============start store================");
		String storeCate = store.getStoreBusinessType();
		String[] array = storeCate.split(",");
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		model.addAttribute("store", array);
		System.out.println("===============end store================");
		String result = storeService.addStore(store);
		System.out.println("================start result===============");
		System.out.println(result);
		System.out.println("================end result===============");
		store.setSpaceRelationStoreCode(store.getStoreCode());
		store.setSpaceRelationCateCode(store.getSpaceRelationCateCode());
		
		return "space/addSpace";
	}
	
	@GetMapping("/addStore")
	public String addStore(Model model) {
		model.addAttribute("title", "업체 등록");
		return "store/addStore";
	}
	
	@GetMapping("/storeListOK")
	public String storeList(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("title", "업체 리스트");
		model.addAttribute("storeList", storeList);
		return "store/storeListOK";
	}
}	