package com.urban.spatium.controller;

import java.util.List;

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
	
	@GetMapping("/rsvDetailInsertByAdmin")
	public String rsvDetailInsertByAdmin() {
		return "rsv/rsvDetailInsertByAdmin";
	}
	
	@PostMapping("/rsvInsertByAdmin")
	public String rsvInsertByAdmin(Rsv rsv, Model model) {
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
		
		
		return "rsv/rsvInsertByAdmin";
	}
	
	@GetMapping("/rsvListByAdmin")
	public String rsvListByAdmin(Model model) {
		List<Rsv> rsvList = rsvService.rsvList();
		model.addAttribute("rsvList", rsvList);
		return "rsv/rsvListByAdmin";
	}
	
	@GetMapping("/rsvDetailListByAdmin")
	public String rsvDetailListByAdmin(Model model) {
		List<Rsv> rsvList = rsvService.rsvList();
		model.addAttribute("rsvList", rsvList);
		return "rsv/rsvDetailListByAdmin";
	}
	
	@GetMapping("/rsvCancelListByAdmin")
	public String rsvCancelListByAdmin() {
		return "rsv/rsvCancelListByAdmin";
	}
	
}
