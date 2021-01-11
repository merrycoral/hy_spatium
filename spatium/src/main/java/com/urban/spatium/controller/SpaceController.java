package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.dto.Store;
import com.urban.spatium.service.SpaceService;

@Controller
public class SpaceController {
	
	@Autowired
	private SpaceService spaceService;
	
	@PostMapping("/spaceListReady")
	public String addSpace(Model model, ReadySpace readySpace, String readyStoreBusinessType
								,@RequestParam(name = "readyStoreCode", required = false) String readyStoreCode) {
			System.out.println(readySpace);
			System.out.println(readyStoreCode + " readyStoreCode");
			String ReadyStore = spaceService.addReadySpace(readySpace, readyStoreCode, readyStoreBusinessType);
			System.out.println(ReadyStore);
			
		return "redirect:/spaceListReady";
	}
	
	@GetMapping("/addSpace")
	public String addSpace(Model model, HttpSession session, Store store, String storeCode) {
		System.out.println(storeCode + "spacecontroller에서 받은 스토어 코드 값");
		model.addAttribute("title", "공간 등록");
		String storeId = (String) session.getAttribute("SID");
		store.setStoreId(storeId);
		String okId = store.getStoreId();
		System.out.println(okId + "스페이스 컨트롤러에서 받은 okId");
		String spaceCateList = spaceService.addSpace(storeCode);
		System.out.println(spaceCateList);
		String[] array = spaceCateList.split(",");
		model.addAttribute("storeBusiness", array);
		model.addAttribute("storeCode", storeCode);
		
		return "space/addSpace";
	}
	
	@GetMapping("/addSpaceChoice")
	public String addSpaceChoice(Model model, HttpSession session, Store store) {
		model.addAttribute("title", "공간 등록");
		String storeId = (String) session.getAttribute("SID");
		store.setStoreId(storeId);
		List<Store> spaceChoice = spaceService.addSpaceChoice(storeId);
		model.addAttribute("spaceChoice", spaceChoice);
		
		return "space/addSpaceChoice";
	}
	
	@GetMapping("/spaceListReady")
	public String readySpaceList(Model model) {
		List<ReadySpace> readySpaceList = spaceService.readySpaceList();
			model.addAttribute("title", "공간 승인 대기 리스트");
			model.addAttribute("readySpaceList", readySpaceList);
		return "space/readySpaceList";
	}
	
	@GetMapping("/spaceListOK")
	public String OKSpaceList(Model model) {
		List<OKSpace> spaceListO = spaceService.OKSpaceList();
			model.addAttribute("title", "공간 승인 완료 리스트");
			model.addAttribute("spaceListO", spaceListO);
		return "space/OKSpaceList";
	}
	
}