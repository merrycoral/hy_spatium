package com.urban.spatium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.service.RsvService;

@Controller
public class RsvController {
	@Autowired 
	private RsvService rsvService; 
	
	/**
	 * 예약 등록 메서드
	 */
	@GetMapping("/rsvDetailInsertByAdmin")
	public String rsvDetailInsertByAdmin(Model model) {
		model.addAttribute("storeCode", 5);
		//넘어온 업체 코드가 5라고 가정
		
		List<OKSpace> getSpaceByStore = rsvService.getSpaceByStore();//업체에 소속된 공간 가져오기
		List<Item> getItemByStore = rsvService.getItemByStore();//업체에 소속된 장비 가져오기
		model.addAttribute("getSpaceByStore", getSpaceByStore);
		model.addAttribute("getItemByStore", getItemByStore);
		
		
		return "rsv/rsvDetailInsertByAdmin";
	}
	
	/**
	 * 예약 등록 버튼 눌렀을때 작동하는 메서드
	 */
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
	
	/**
	 * 관리자페이지 예약 목록 조회
	 */
	@GetMapping("/rsvListByAdmin")
	public String rsvListByAdmin(Model model) {
		List<Rsv> rsvList = rsvService.rsvList();
		model.addAttribute("rsvList", rsvList);
		return "rsv/rsvListByAdmin";
	}
	
	/**
	 * 관리자페이지 예약 세부 목록 조회
	 */
	@GetMapping("/rsvDetailListByAdmin")
	public String rsvDetailListByAdmin(Model model) {
		List<Rsv> rsvDetailList = rsvService.rsvDetailList();
		model.addAttribute("rsvDetailList", rsvDetailList);
		return "rsv/rsvDetailListByAdmin";
	}
	
	/**
	 * 관리자페이지 예약 취소 목록 조회
	 */
	@GetMapping("/rsvCancelListByAdmin")
	public String rsvCancelListByAdmin() {
		return "rsv/rsvCancelListByAdmin";
	}
	
}
