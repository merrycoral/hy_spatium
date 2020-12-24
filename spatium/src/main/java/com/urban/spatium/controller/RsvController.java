package com.urban.spatium.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.service.RsvService;

@Controller
public class RsvController {
	@Autowired 
	private RsvService rsvService; 
	
	@GetMapping("/rsvListExtend")
	public String rsvListExtend(Model model, @RequestParam(name = "", required =false)String rsvCode) {
		List<Rsv> rsvListExtend = rsvService.rsvListExtend(rsvCode);
		model.addAttribute("rsvListExtend", rsvListExtend);
		return "rsv/rsvListExtend";
	}
	
	@RequestMapping(value = "/rsvInsertAjax", produces="application/json"  ,method = RequestMethod.POST ) 
	public @ResponseBody String addInOutPut(@RequestBody Rsv rsv, HttpSession session) {
		System.out.println("예약날짜 --> "+rsv.getRsvDate());
		System.out.println("시작시간 --> "+rsv.getStartTime());
		System.out.println("종료시간 --> "+rsv.getEndTime());
		System.out.println("예약이름 --> "+rsv.getRsvUserName());
		System.out.println("예약자폰 --> "+rsv.getRsvUserPhone());
		System.out.println("예약자 이메일 --> "+rsv.getRsvUserEmail());
		System.out.println("요청사항 --> "+rsv.getRsvUserRequest());
		System.out.println("공간 리스트 --> "+rsv.getSpaceList());
		System.out.println("장비 리스트 --> "+rsv.getItemList());
		
		String sessionId = (String) session.getAttribute("SID");
		rsv.setRsvUserId(sessionId); // 임시 아이디 부여
		rsvService.insertTbRsv(rsv);
	    
	    return "/admin";
	}
	
	
	/**
	 * 예약 등록 메서드
	 */
	@GetMapping("/rsvInsertAdmin")
	public String rsvInsertAdmin(Model model) {
		int storeCode = 5; //넘어온 업체코드가 5라고 가정
		
		List<OKSpace> getSpaceByStore = rsvService.getSpaceByStore(storeCode);//업체에 소속된 공간 가져오기
		List<Item> getItemByStore = rsvService.getItemByStore(storeCode);//업체에 소속된 장비 가져오기
		model.addAttribute("getSpaceByStore", getSpaceByStore);
		model.addAttribute("getItemByStore", getItemByStore);
		
		
		return "rsv/rsvInsertAdmin";
	}
	
	
	/**
	 * 관리자페이지 예약 목록 조회
	 */
	@GetMapping("/rsvListAdmin")
	public String rsvListByAdmin(Model model) {
		List<Rsv> rsvList = rsvService.rsvList();
		model.addAttribute("rsvList", rsvList);
		return "rsv/rsvListAdmin";
	}
	
	/**
	 * 관리자페이지 예약 세부 목록 조회
	 */
	@GetMapping("/rsvDetailListAdmin")
	public String rsvDetailListByAdmin(Model model) {
		List<Rsv> rsvDetailList = rsvService.rsvDetailList();
		model.addAttribute("rsvDetailList", rsvDetailList);
		return "rsv/rsvDetailListAdmin";
	}
	
	/**
	 * 관리자페이지 예약 취소 목록 조회
	 */
	@GetMapping("/rsvCancelListAdmin")
	public String rsvCancelListByAdmin() {
		return "rsv/rsvCancelListAdmin";
	}
	
}
