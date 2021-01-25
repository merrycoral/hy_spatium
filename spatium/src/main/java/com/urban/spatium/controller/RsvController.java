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
	 * 예약수 통계(관리자)
	 */
	@GetMapping("/statistic/admin/rsvStatAdmin")
	public String rsvStatAdmin(Model model, @RequestParam(name="options", required = false)String day) {
		System.out.println("day : "+day);
		List<Map<String, Object>> rsvStatAdmin = null;
		if(day==null) {
			//전체
			rsvStatAdmin = rsvService.rsvStatAdmin();
		}else{
			//일,주,월간
			rsvStatAdmin = rsvService.rsvStatAdmin(day);
		}
		model.addAttribute("title", "업체별 예약 통계");
		model.addAttribute("rsvStatAdmin", rsvStatAdmin);
		model.addAttribute("day", day);
		return "reservation/admin/rsvStatAdmin";
	}
	
	/**
	 * 예약 취소(관리자)
	 */
	@GetMapping("/reservation/admin/rsvCancel")
	public String rsvCancelAdmin(int rsvCode, String rsvState, HttpServletResponse response) throws IOException {
		System.out.println("예약 상태 --> " + rsvState);
		//결제가 완료된 예약일시 환불하도록 유도
		if("결제 완료".equals(rsvState)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 결제가 완료되었습니다. 결제 페이지에서 환불해주세요'); location.href=\"/payment/admin/paymentSearch\";</script>");
			out.flush();
			return "index";
		}else if ("환불 완료".equals(rsvState)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 결제 취소 및 환불이 완료되었습니다.'); location.href=\"/reservation/admin/rsvListAdmin\";</script>");
			out.flush();
			return "index";
		}
		
		//미결제된 예약일시 바로 취소 및 DB에서 삭제(릴레이션, 예약, 세부예약 삭제)
		System.out.println("삭제할 예약 코드 --> " + rsvCode);
		rsvService.cancelRsv(rsvCode);
		return "redirect:reservation/admin/rsvListAdmin";
	}
	
	/**
	 * 예약 취소(구매자)
	 */
	@GetMapping("/reservation/rsvCancel")
	public String rsvCancel(int rsvCode, String rsvState, HttpServletResponse response) throws IOException {
		System.out.println("예약 상태 --> " + rsvState);
		//결제가 완료된 예약일시 환불하도록 유도
		if("결제 완료".equals(rsvState)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 결제가 완료되었습니다. 결제 페이지에서 환불해주세요'); location.href=\"/payment/paymentSearch\";</script>");
			out.flush();
			return "index";
		}else if ("환불 완료".equals(rsvState)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 결제 취소 및 환불이 완료되었습니다.'); location.href=\"/reservation/rsvList\";</script>");
			out.flush();
			return "index";
		}
		
		//미결제된 예약일시 바로 취소 및 DB에서 삭제(릴레이션, 예약, 세부예약 삭제)
		System.out.println("삭제할 예약 코드 --> " + rsvCode);
		rsvService.cancelRsv(rsvCode);
		return "redirect:reservation/rsvList";
	}
	
	/**
	 * 기 예약된 장비 가져오는 ajax
	 */
	@ResponseBody
	@RequestMapping(value = "/getExItemRsv", produces="application/json"  ,method = RequestMethod.POST ) 
	public List<Rsv> getExItemRsv(@RequestBody Rsv rsv) {
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
		System.out.println("가져오기 -->  "+rsv.getRsvType());
		List<Rsv> getExRsv = null;
		getExRsv = rsvService.getExRsv(rsv);
		return getExRsv;
	}
	
	/**
	 * 관리자 예약 리스트 확장
	 */
	@GetMapping("/reservation/seller/rsvListExtendAdmin")
	public String rsvListExtendAdmin(Model model, @RequestParam(name = "", required =false)String rsvCode) {
		List<Rsv> rsvListExtend = rsvService.rsvListExtend(rsvCode);
		model.addAttribute("title", "세부 예약 리스트 보기");
		model.addAttribute("rsvListExtend", rsvListExtend);
		return "reservation/seller/rsvListExtendAdmin";
	}
	
	/**
	 * 구매자 예약 리스트 확장
	 */
	@GetMapping("/reservation/rsvListExtend")
	public String rsvListExtend(Model model, @RequestParam(name = "", required =false)String rsvCode) {
		List<Rsv> rsvListExtend = rsvService.rsvListExtend(rsvCode);
		model.addAttribute("title", "나의 세부 예약 리스트");
		model.addAttribute("rsvCode", rsvCode);
		model.addAttribute("rsvListExtend", rsvListExtend);
		return "reservation/rsvListExtend";
	}
	
	/**
	 * 예약 하는 ajax
	 */
	@RequestMapping(value = "/rsvInsertAjax", produces="application/json"  ,method = RequestMethod.POST ) 
	public @ResponseBody String addInOutPut(@RequestBody Rsv rsv, HttpSession session) throws IOException {
		String returnPath = "/reservation/rsvList";
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
		System.out.println("페이지 타입--> "+rsv.getPageType());
		
		String sessionId = (String) session.getAttribute("SID");
		rsv.setRsvUserId(sessionId); // 세션 아이디 부여
		List<Rsv> result = rsvService.insertTbRsv(rsv);
	    if(result!=null && result.size()>0) {
	    	return "/reservation/rsvInsert?storeCode="+rsv.getRsvStoreCode()+"&rsvType="+rsv.getRsvState()+"&rsvCheck=0";
	    }
	    if("admin".equals(rsv.getPageType())) {
	    	System.out.println("관리자페이지로");
	    	returnPath = "/reservation/admin/rsvListAdmin";
	    }
	    System.out.println("구매자 페이지로");
	    return returnPath;
	}
	
	
	/**
	 * 예약 등록 폼으로 이동
	 */
	@GetMapping("/reservation/rsvInsert")
	public String rsvInsert(Model model,int storeCode, String rsvType
			, @RequestParam(name="rsvCheck", required = false)String rsvCheck
			, @RequestParam(name="pageType", required = false)String pageType) {
		String returnPath = "/";
		List<OKSpace> getSpaceByStore = rsvService.getSpaceByStore(storeCode);//업체에 소속된 공간 가져오기
		List<Item> getItemByStore = rsvService.getItemByStore(storeCode);//업체에 소속된 장비 가져오기
		model.addAttribute("title", "예약 등록");
		model.addAttribute("getSpaceByStore", getSpaceByStore);
		model.addAttribute("getItemByStore", getItemByStore);
		model.addAttribute("storeCode", storeCode);
		model.addAttribute("rsvCheck", rsvCheck);
		if("admin".equals(pageType)) {
			if("시간".equals(rsvType)) {
				returnPath = "reservation/admin/rsvInsertAdmin";
			}else if("일".equals(rsvType)){
				returnPath = "reservation/admin/rsvInsertDayAdmin";
			}
		}else {
			if("시간".equals(rsvType)) {
				returnPath = "reservation/rsvInsert";
			}else if("일".equals(rsvType)){
				returnPath = "reservation/rsvInsertDay";
			}
		}
		return returnPath;
	}
	
	/**
	 * 관리자페이지 예약 목록 조회(관리자용)
	 */
	@GetMapping("/reservation/admin/rsvListAdmin")
	public String rsvListAdmin(Model model) {
		List<Rsv> rsvList = rsvService.rsvListAdmin();
		model.addAttribute("title", "예약 목록");
		model.addAttribute("rsvList", rsvList);
		return "reservation/admin/rsvListAdmin";
	}
	
	/**
	 * 관리자페이지 예약 목록 조회(판매자용)
	 */
	@GetMapping("/reservation/seller/rsvListAdminByStore")
	public String rsvListAdminByStore(Model model, HttpSession session) {
		String storeId = (String) session.getAttribute("SID");
		List<Rsv> rsvList = rsvService.rsvListAdminByStore(storeId);
		model.addAttribute("title", "예약 목록");
		model.addAttribute("rsvList", rsvList);
		return "reservation/seller/rsvListAdminByStore";
	}
	
	/**
	 * 구매자페이지 예약 목록 조회(구매자용)
	 */
	@GetMapping("/reservation/rsvList")
	public String rsvList(Model model, HttpSession session) {
		String sessionId = (String) session.getAttribute("SID");
		List<Rsv> rsvList = rsvService.rsvList(sessionId);
		model.addAttribute("title", "예약 목록");
		model.addAttribute("rsvList", rsvList);
		return "reservation/rsvList";
	}
	
	/**
	 * 관리자페이지 예약 세부 목록 조회(관리자용)
	 */
	@GetMapping("/reservation/admin/rsvDetailListAdmin")
	public String rsvDetailListAdmin(Model model) {
		List<Rsv> rsvDetailList = rsvService.rsvDetailList();
		model.addAttribute("title", "세부 예약 목록");
		model.addAttribute("rsvDetailList", rsvDetailList);
		return "reservation/admin/rsvDetailListAdmin";
	}
	
	/**
	 * 관리자페이지 예약 세부 목록 조회(판매자용)
	 */
	@GetMapping("/reservation/seller/rsvDetailListAdminByStore")
	public String rsvDetailListAdminByStore(Model model, HttpSession session) {
		String storeId = (String) session.getAttribute("SID");
		List<Rsv> rsvDetailList = rsvService.rsvDetailListByStore(storeId);
		model.addAttribute("title", "세부 예약 목록");
		model.addAttribute("rsvDetailList", rsvDetailList);
		return "reservation/seller/rsvDetailListAdminByStore";
	}
	
	/**
	 * 예약 업체 선택 화면으로 이동 
	 */
	@GetMapping("/reservation/admin/rsvStoreList")
	public String rsvStoreList(Model model) {
		List<Store> storeList = storeService.storeList();
		model.addAttribute("title", "예약할 업체 리스트");
		model.addAttribute("storeList", storeList);
		return "reservation/admin/rsvStoreList";
	}
	
}
