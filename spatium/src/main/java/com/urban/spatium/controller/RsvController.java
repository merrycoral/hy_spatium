package com.urban.spatium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Rsv;
import com.urban.spatium.service.RsvService;

@Controller
public class RsvController {
	@Autowired 
	private RsvService rsvService; 
	
	@GetMapping("/rsvInsert")
	public String index() {
		return "rsv/rsvInsert";
	}
	
	@PostMapping("/rsvInsert")
	public String index2(Rsv rsv, Model model) {
		System.out.println(rsv.getRsvDate() + " <-- 예약날짜");
		System.out.println(rsv.getStartTime() + " <-- 시작시간");
		System.out.println(rsv.getEndTime() + " <-- 종료시간");
		System.out.println(rsv.getRsvUserName() + " <-- 예약자");
		System.out.println(rsv.getRsvUserPhone() + " <-- 예약자 폰");
		System.out.println(rsv.getRsvUserEmail() + " <-- 예약자 이메일");
		System.out.println(rsv.getRsvUserRequest() + " <-- 요청사항");
		
		rsv.setRsvUserId("sessionId");
		rsv.setRsvTotalPrice(50000);
		
		rsvService.insertTbRsv(rsv);
		
		
		return "rsv/rsvInsert";
	}
	
	@GetMapping("/rsvList")
	public String rsvList(Model model) {
		
		
		return "rsv/rsvList";
	}
	
	@GetMapping("/rsvCancelList")
	public String rsvCancelList() {
		return "rsv/rsvCancelList";
	}
	
}
