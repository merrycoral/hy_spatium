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
	
	@PostMapping("/storeUpdate")
	public String updateStoreSet(Model model, Store store) {
		
			String result = storeService.updateStoreSet(store);
			System.out.println(result);
			model.addAttribute("result", result);
			
		return "redirect:/storeListOK";
	}
	
	@GetMapping("/storeUpdate")
	public String updateStore(Model model, Store store
							, @RequestParam(name = "storeCode", required = false) int storeCode) {
			Store result = storeService.updateStore(storeCode);
		System.out.println(storeCode + "==== 업체 수정에서 가져온 스토어 코드 ====");
			model.addAttribute("title", "업체 수정");
			model.addAttribute("result", result);
		return "store/updateStore";
	}
	
	@PostMapping("/addSpace")
	public String addStore(Model model, Store store) {

		System.out.println("스토어 받은값 --> "+store);
		store.getStoreCode();
		System.out.println("===============start store================");
		String storeCate = store.getStoreBusinessType();
		
		String[] array = storeCate.split(",");
		int[] i_array = new int[10];
		int arrayCheck = 0;
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
			
			if(array[i].equals("촬영 스튜디오")) {
				arrayCheck = 1;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("엠티장소")) {
				arrayCheck = 2;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("스터디룸")) {
				arrayCheck = 3;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("연습실")) {
				arrayCheck = 4;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("파티룸")) {
				arrayCheck = 5;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("회의실")) {
				arrayCheck = 6;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("카페")) {
				arrayCheck = 7;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("다목적홀")) {
				arrayCheck = 8;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("공연장")) {
				arrayCheck = 9;
				i_array[i]=arrayCheck;
			}
			if(array[i].equals("한옥")) {
				arrayCheck = 10;
				i_array[i]=arrayCheck;
			}
			
			System.out.println(arrayCheck + "arrayCheck 숫자");
			System.out.println("######################");
			
		}
		for(int j=0; j<array.length; j++) {
			System.out.println(i_array[j]);
		}
		
		model.addAttribute("storeBusiness", array);
		System.out.println("===============end store================");
		String result = storeService.addStore(store);
		System.out.println("================start result===============");
		System.out.println(result);
		System.out.println("================end result===============");
		store.setSpaceRelationStoreCode(store.getStoreCode());

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