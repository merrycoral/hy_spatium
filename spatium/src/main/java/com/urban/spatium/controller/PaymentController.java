package com.urban.spatium.controller;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.User;
import com.urban.spatium.service.PaymentService;
import com.urban.spatium.service.UserService;




@Controller
public class PaymentController {
	@Autowired 
	private PaymentService paymentService; 
	@Autowired
	private UserService userService;
	
	
	/* 구매자 포인트  (관리자화면)*/

	/* 구매자 포인트  (구매자화면)*/
	@GetMapping("/point/pointListMain")
	public String pointListMain(Model model, HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		List<Point> pointList = paymentService.userPointSelect(SID);
		System.out.println(pointList);
		String totalPoint =paymentService.totalPoint(SID);
		model.addAttribute("title", "회원 포인트 조회");
		model.addAttribute("pointList", pointList);
		model.addAttribute("totalPoint", totalPoint);
		return "point/pointListMain";
	}
	
	
	
	@GetMapping("/payment/rsvDetail")
	public @ResponseBody Map<String, Object> rsvDetail(Model model,
						@RequestParam String payCode) {
		System.out.println("여기왔다.");
		System.out.println(payCode);
		paymentService.rsvDetail(payCode);
		System.out.println(paymentService.rsvDetail(payCode));
	    Map<String, Object> rsvDetailMap = new HashMap<String, Object>();
	    rsvDetailMap.put("rsvDetail",paymentService.rsvDetail(payCode));
		
		return rsvDetailMap;		
	}
	@GetMapping("/payment/paymentSSilpae")
	public String paymentSSilpae(Model model) {
		
		model.addAttribute("title", "결제실패화면");
		return "payment/paymentSSilpae";
	}
	
	@PostMapping("/payment/paymentTest")
	public  String paymentTest(Model model,Payment payment
						,@RequestParam(name = "pointID",required = false)String pointID
						,@RequestParam(name = "usePoint",required = false)int usePoint
						,@RequestParam(name = "addPoint",required = false)int addPoint
						,@RequestParam(name = "paymentRsvCode",required = false)int PaymentRsvCode) {
		System.out.println("===여기부터====");
		
		System.out.println(payment.getPaymentPrice()+"getPaymentPrice");
		System.out.println(payment.getPaymentRsvCode()+"getPaymentRsvCode");
		System.out.println(payment.getPaymentUsePoint()+"getPaymentUsePoint");
		System.out.println(payment.getPaymentUseMoney()+"getPaymentUseMoney");
		System.out.println(payment.getPaymentAddPoint()+"getPaymentAddPoint");
		System.out.println(payment.getPaymentIP()+"getPaymentIP");
		System.out.println(payment.getPaymentStoreCode()+"getPaymentStoreCode");
		System.out.println(PaymentRsvCode +"PaymentRsvCode의 값");
		System.out.println("유즈포인트"+(usePoint*-1));
		System.out.println("에드포인트"+addPoint);
		
		payment.setPaymentStoreId(payment.getPaymentStoreId());
		payment.setPaymentPrice(payment.getPaymentPrice());
		payment.setPaymentRsvCode(PaymentRsvCode);
		payment.setPaymentUsePoint(usePoint);
		payment.setPaymentUseMoney(payment.getPaymentUseMoney());
		payment.setPaymentAddPoint(addPoint);
		payment.setPaymentIP(payment.getPaymentIP());
		payment.setPaymentStoreCode(payment.getPaymentStoreCode());
		int pay = paymentService.paymentSystem(payment);
		System.out.println(pay + "pay의 값");
		
		payment.getPaymentCode();// seq 추출 가능
		Point point = new Point();
		Rsv rsv = new Rsv();
		point.setPointAddList("결제 완료");
		point.setPointID(pointID);
		point.setPointSellList("포인트 적립");
		point.setPointList(addPoint);
		point.setPointPaymentCode(payment.getPaymentCode());
		int result1=paymentService.addPoint(point);
		System.out.println(result1 +"result1값");
		
		
		rsv.setRsvState("결제 완료");
		rsv.setRsvCode(PaymentRsvCode);
		int setstate = paymentService.updateState(rsv);
		
		if(usePoint!=0) {
			point = new Point();
			
			point.setPointAddList("결제 사용");
			point.setPointID(pointID);
			point.setPointSellList("포인트 사용");
			point.setPointList(usePoint*-1);
			point.setPointPaymentCode(payment.getPaymentCode());
			int result2 = paymentService.addPoint(point);
			System.out.println(result2 +"result2값");
			
		}
		
		int a = payment.getPaymentCode();
		Payment paymentcode =paymentService.paymentSuccess(a);
		System.out.println(paymentcode+"페이먼트코드값<<<<<<<<<<<<<<");
		System.out.println("여기");
		model.addAttribute("pay", paymentcode);
		System.out.println(pay+"pay<<<<<<<<<<<<<<<<<");
		
		return "payment/paymentSuccess";
		
	}
	
	
	@RequestMapping(value = "/ajaxTest", produces="application/json"  ,method = RequestMethod.POST ) 
	   public @ResponseBody void ajaxTest(@RequestBody String money) {
	      System.out.println("메인컨트롤러 .>>..");
	      System.out.println(money);
	    }

	
	@GetMapping("/payment/paymentTest")
	public  String test(Model model
					,@RequestParam(name="rsvCode", required = false) String rsvCode
					) {
		System.out.println("hiihi");
		System.out.println(rsvCode);
		
		//memberService.onelist(member.getMemberId());
		
		Rsv rsv = paymentService.rsvState(rsvCode);
		
		//이건 조건문 돌리기위한 변수선언
		String dateTime = "";
		System.out.println("여기>>>"+paymentService.getRsvDetailCode(rsvCode,dateTime));
		//조건문이 공백이여서 코드만 불러온다
		List<Map<String, Object>> rsvDetailMap = paymentService.getRsvDetailCode(rsvCode,dateTime);
		dateTime = "notNull";
		//조건문이 공백이 아니여서 코드+시간 불러온다
		List<Map<String, Object>> rsvDateTimeMap = paymentService.getRsvDetailCode(rsvCode,dateTime);
		
		System.out.println("코드만>>"+rsvDetailMap);
		System.out.println("시간포함>>"+rsvDateTimeMap);
		
		//for each문을 돌리기위해 Map<List<Map<>>> 형태로 만들기위한 작업
		Map<String,Object> totalMap = new HashMap<String,Object>();
		List<Map<String, Object>> newRsvDetailMap = new ArrayList<Map<String,Object>>();
		for(int i=0; i<rsvDetailMap.size();i++) {
			
			for(Map.Entry<String, Object> elem : rsvDetailMap.get(i).entrySet()){
				Map<String,Object> map = new HashMap<String,Object>();
				System.out.println("키 : " + elem.getKey() + "값 : " + elem.getValue());
				map.put("columName", elem.getKey());
				map.put("columValue", elem.getValue());
				map.put("rsvStartDateTime",rsvDateTimeMap.get(i).get("rsvStartDateTime"));
				map.put("rsvEndDateTime",rsvDateTimeMap.get(i).get("rsvEndDateTime"));
				newRsvDetailMap.add(map);	
	        }
		}
		System.out.println("리스트맵>>>"+newRsvDetailMap);
		totalMap.put("list", newRsvDetailMap);
		System.out.println(totalMap);
		System.out.println("결고값>>>"+paymentService.rsvCheck(totalMap));
		int result = paymentService.rsvCheck(totalMap);
		String result2=null;
		if(result==0) {
			result2 = "O";
		}else {
			result2 = "X";
		}
		
		
		model.addAttribute("result",result2 );
		model.addAttribute("rsv", rsv);
		System.out.println(rsv.getRsvUserId());
		System.out.println(rsv.getRsvCode());
		String totalPoint =paymentService.totalPoint(rsv.getRsvUserId());
		//마일리지 총값
		System.out.println("포인트"+totalPoint);
		model.addAttribute("totalPoint", totalPoint);
		//한개예약리스트
		model.addAttribute("rsvDetailList", paymentService.getRsvDetailCode(rsvCode,dateTime));
		
		
		
		return "payment/payment";
		
	}
	
	//구매자 페이지 결제내역
	@GetMapping("/payment/paymentSearchMain")
	public String paymentSearchMain(Model model,HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		List<Payment> userpaymentList = paymentService.paymentSelect(SID);
		System.out.println("컨트롤러!!!1" + userpaymentList);
		model.addAttribute("title", "결제내역조회");
		model.addAttribute("paymentList", userpaymentList);
		return "payment/paymentSearchMain";
	}
	
	//판매자 페이지 결제내역
	@GetMapping("/payment/seller/paymentSearchMyStore")
	public String paymentSearchMyStore(Model model,HttpSession session) {
		String SID = (String) session.getAttribute("SID");
		List<Payment> storepaymentList = paymentService.StorePaymentSelect(SID);
		System.out.println("컨트롤러!!!1" + storepaymentList);
		model.addAttribute("title", "결제내역조회");
		model.addAttribute("paymentList", storepaymentList);
		return "payment/seller/paymentSearchMyStore";
	}
	//관리자 페이지 결제내역
	@GetMapping("/payment/admin/paymentSearch")
	public String paymentSearch(Model model) {
		
		List<Payment> paymentList = paymentService.allPaymentSelect();
		System.out.println("컨트롤러!!!1" + paymentList);
		model.addAttribute("title", "결제내역조회");
		model.addAttribute("paymentList", paymentList);
		return "payment/admin/paymentSearch";
	}
	
	@GetMapping("/point/admin/pointSearch")
	public String pointSearch(Model model) {
		 
		List<Point> pointList = paymentService.pointSelect();
		
		model.addAttribute("title", "마일리지 사용내역 조회");
		model.addAttribute("pointList", pointList);
		return "point/admin/allPointSearch";
	}
}
