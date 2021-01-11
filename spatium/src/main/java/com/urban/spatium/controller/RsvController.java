package com.urban.spatium.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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
import com.urban.spatium.dto.Store;
import com.urban.spatium.dto.Item;
import com.urban.spatium.dto.OKSpace;
import com.urban.spatium.service.RsvService;
import com.urban.spatium.service.StoreService;

@Controller
public class RsvController {
	@Autowired 
	private RsvService rsvService; 
	@Autowired 
	private StoreService storeService;
	
	/**
	 * 예약 통계(판매자)
	 */
	@GetMapping("/rsvStatStore")
	public String rsvStat(Model model) {
		List<Map<String, Object>> rsvStatAdmin = rsvService.rsvStatAdmin();
		model.addAttribute("title", "나의 예약 통계");
		model.addAttribute("rsvStatAdmin", rsvStatAdmin);
		return "rsv/rsvStatStore";
	}
	
	/**
	 * 예약수 통계(관리자)
	 */
	@GetMapping("/rsvStatAdmin")
	public String rsvStatAdmin(Model model) {
		List<Map<String, Object>> rsvStatAdmin = rsvService.rsvStatAdmin();
		model.addAttribute("title", "업체별 예약 통계");
		model.addAttribute("rsvStatAdmin", rsvStatAdmin);
		return "rsv/rsvStatAdmin";
	}
	
	/**
	 * 예약 취소
	 */
	@GetMapping("/rsvCancel")
	public String rsvCancel(int rsvCode, String rsvState, HttpServletResponse response) throws IOException {
		System.out.println("예약 상태 --> " + rsvState);
		//결제가 완료된 예약일시 환불하도록 유도
		if("결제 완료".equals(rsvState)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 결제가 완료되었습니다. 결제 페이지에서 환불해주세요'); location.href=\"paymentSearch\";</script>");
			out.flush();
			System.out.println("여기 안도나");
			return "index";
		}
		
		//미결제된 예약일시 바로 취소 및 DB에서 삭제(릴레이션, 예약, 세부예약 삭제)
		System.out.println("삭제할 예약 코드 --> " + rsvCode);
		rsvService.cancelRsv(rsvCode);
		return "redirect:rsvListAdmin";
	}
	
	/**
	 * 기 예약된 장비 가져오는 ajax
	 */
	@RequestMapping(value = "/getExItemRsv", produces="application/json"  ,method = RequestMethod.POST ) 
	public @ResponseBody List<Rsv> getExItemRsv(@RequestBody Rsv rsv) {
		System.out.println("에이작스"+rsv);
		List<Rsv> getExItemRsv = rsvService.getExItemRsv(rsv);
		
		return getExItemRsv;
	}
	
	/**
	 * 기 예약된 공간 가져오는 ajax
	 */
	@RequestMapping(value = "/getExRsv", produces="application/json"  ,method = RequestMethod.POST ) 
	public @ResponseBody List<Rsv> getExRsv(@RequestBody Rsv rsv) {
		System.out.println("가져오기 -->  "+rsv.getSpaceList());
		System.out.println("가져오기 -->  "+rsv.getRsvDate());
		List<Rsv> getExRsv = null;
		getExRsv = rsvService.getExRsv(rsv);
		return getExRsv;
	}
	
	/**
	 * 예약 리스트
	 */
	@GetMapping("/rsvListExtend")
	public String rsvListExtend(Model model, @RequestParam(name = "", required =false)String rsvCode) {
		List<Rsv> rsvListExtend = rsvService.rsvListExtend(rsvCode);
		model.addAttribute("rsvListExtend", rsvListExtend);
		return "rsv/rsvListExtend";
	}
	
	/**
	 * 예약 하는 ajax
	 */
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
		System.out.println("업체 번호 --> "+rsv.getRsvStoreCode());
		
		String sessionId = (String) session.getAttribute("SID");
		rsv.setRsvUserId(sessionId); // 임시 아이디 부여
		rsvService.insertTbRsv(rsv);
	    
	    return "/rsvListAdmin";
	}
	
	
	/**
	 * 공간 예약 등록으로 이동(관리자화면)
	 */
	@GetMapping("/rsvInsertAdmin")
	public String rsvInsertAdmin(Model model, int storeCode, String rsvType) {
		List<OKSpace> getSpaceByStore = rsvService.getSpaceByStore(storeCode);//업체에 소속된 공간 가져오기
		List<Item> getItemByStore = rsvService.getItemByStore(storeCode);//업체에 소속된 장비 가져오기
		model.addAttribute("getSpaceByStore", getSpaceByStore);
		model.addAttribute("getItemByStore", getItemByStore);
		model.addAttribute("storeCode", storeCode);
		if("시간".equals(rsvType)) {
			return "rsv/rsvInsertAdmin";
		}else if("일".equals(rsvType)){
			return "rsv/rsvInsertDayAdmin";
		}else {
			return "/";
		}
	}
	
	
	/**
	 * 공간 예약 등록으로 이동(구매자화면)
	 */
	@GetMapping("/rsvInsert")
	public String rsvInsert(Model model,int storeCode, String rsvType) {
		List<OKSpace> getSpaceByStore = rsvService.getSpaceByStore(storeCode);//업체에 소속된 공간 가져오기
		List<Item> getItemByStore = rsvService.getItemByStore(storeCode);//업체에 소속된 장비 가져오기
		model.addAttribute("getSpaceByStore", getSpaceByStore);
		model.addAttribute("getItemByStore", getItemByStore);
		model.addAttribute("storeCode", storeCode);
		
		if("시간".equals(rsvType)) {
			return "rsv/rsvInsert";
		}else if("일".equals(rsvType)){
			return "rsv/rsvInsertDay";
		}else {
			return "/";
		}
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
	 * 예약 업소 선택 화면으로 이동 
	 */
	@GetMapping("/rsvStoreList")
	public String rsvStoreList(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("title", "업체 리스트");
		model.addAttribute("storeList", storeList);
		return "rsv/rsvStoreList";
	}
	
}
