package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Access;
import com.urban.spatium.service.AccessService;

@Controller
public class StatisticController {
	
	@Autowired
	private AccessService accessService;

	@GetMapping("/accessStat")
	public String statisticEx(Model model, @RequestParam(name="result", required = false) String result) {
		List<Access> accessList = accessService.getAccessRecord();
		int[] accessCount = accessService.getAccessCount();
		accessService.getBrowserTop4();
		model.addAttribute("title", "접속 목록");
		model.addAttribute("accessList", accessList);
		model.addAttribute("accessTotalCount", accessCount[0]);
		model.addAttribute("accessOtherCount", accessCount[1]);
		if(result != null) model.addAttribute("result", result);
		
		return "statistic/statisticEx";
	}
	//name=result 일치하는 값을 가져오겠다.
	//false일 시 필수X, String result에 null로 들어간다. false시 : localhost/memberList true시 : localhost/memberList?result=123
}
