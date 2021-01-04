package com.urban.spatium.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.Review;
import com.urban.spatium.dto.Store;
import com.urban.spatium.service.ItemService;
import com.urban.spatium.service.ReviewService;
import com.urban.spatium.service.SpaceService;
import com.urban.spatium.service.StoreService;


@Controller
public class MainController {
	@Autowired 
	private StoreService storeService;
	@Autowired 
	private SpaceService spaceService;
	@Autowired 
	private ItemService itemService;
	@Autowired 
	private ReviewService reviewService;
	
	
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
		Store storeInfo = storeService.getStoreInfoByStoreCode(storeCode);
		List<OKSpace> spaceList = spaceService.OKSpaceListByStoreCode(storeCode);
		List<Item> itemCountListByStoreCode = itemService.itemCountListByStoreCode(storeCode);
		List<Map<String,Object>> refundRule = storeService.getRefundRuleByStoreCode(storeCode); 
		List<Review> reviewList = reviewService.getReviewByStoreCode(storeCode);
		model.addAttribute("title", "업체 정보");
		model.addAttribute("storeInfo", storeInfo);
		model.addAttribute("itemCountListByStoreCode", itemCountListByStoreCode);
		model.addAttribute("spaceList", spaceList);
		model.addAttribute("refundRule", refundRule);
		model.addAttribute("reviewList", reviewList);
		return "store/storeInfo";
	}
	
}
