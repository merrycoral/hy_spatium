package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.dto.ReadySpace;
import com.urban.spatium.service.SpaceService;

@Controller
public class SpaceController {
	
	@Autowired
	private SpaceService spaceService;
	
	@PostMapping("/spaceListReady")
	public String addSpace(Model model, ReadySpace readySpace) {
			System.out.println(readySpace);
			System.out.println("sexy");
			String result = spaceService.addReadySpace(readySpace);
			System.out.println(result);
		return "redirect:/spaceListReady";
	}
	
	@GetMapping("/addSpace")
	public String addSpace(Model model) {
		model.addAttribute("title", "공간 등록");
		return "space/addSpace";
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
