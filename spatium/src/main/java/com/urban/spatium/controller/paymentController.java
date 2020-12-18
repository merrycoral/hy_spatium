package com.urban.spatium.controller;




import java.util.List;

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
import com.urban.spatium.service.PaymentService;



@Controller
public class paymentController {
	@Autowired 
	private PaymentService paymentService; 
	
	
	
	
	@GetMapping("/paymentSSilpae")
	public String paymentSSilpae(Model model) {
		model.addAttribute("title", "결제실패화면");
		return "payment/paymentSSilpae";
	}
	
	@PostMapping("/test3")
	public  String test3(Model model,Payment payment
						,@RequestParam(name = "usePoint",required = false)int usePoint
						,@RequestParam(name = "addPoint",required = false)int addPoint) {
		System.out.println("===여기부터====");
		
		System.out.println(payment.getPaymentPrice());
		System.out.println(payment.getPaymentUsePoint());
		System.out.println(payment.getPaymentUseMoney());
		System.out.println(payment.getPaymentAddPoint());
		System.out.println(payment.getPaymentIP());
		System.out.println(payment.getPaymentCode() +"페이먼트 코드");
		System.out.println("유즈포인트"+(usePoint*-1));
		System.out.println("에드포인트"+addPoint);
		
		
		
		payment.getPaymentCode();// seq 추출 가능
		
		
		
		payment.setPaymentPrice(payment.getPaymentPrice());
		payment.setPaymentUsePoint(usePoint);
		payment.setPaymentUseMoney(payment.getPaymentUseMoney());
		payment.setPaymentAddPoint(addPoint);
		payment.setPaymentMethod("예약결제");
		payment.setPaymentIP(payment.getPaymentIP());
		int pay = paymentService.paymentSystem(payment);
		System.out.println(pay + "pay의 값");
		
		Point point = new Point();
		
		point.setPointAddList("결제 완료");
		point.setPointID("id001");
		point.setPointSellList("마일리지 적립");
		point.setPointList(addPoint);
		point.setPointPaymentCode(payment.getPaymentCode());
		int result1=paymentService.addPoint(point);
		System.out.println(result1 +"result1값");
		
		
		
		if(usePoint!=0) {
			point = new Point();
			
			point.setPointAddList("결제 사용");
			point.setPointID("id001");
			point.setPointSellList("마일리지 사용");
			point.setPointList(usePoint*-1);
			point.setPointPaymentCode(payment.getPaymentCode());
			int result2 = paymentService.addPoint(point);
			System.out.println(result2 +"result2값");
			
		}
		
		
		System.out.println("여기");
		return "payment/paymentSuccess";
		
	}
	@RequestMapping(value = "/ajaxTest", produces="application/json"  ,method = RequestMethod.POST ) 
	   public @ResponseBody void ajaxTest(@RequestBody String money) {
	      System.out.println("메인컨트롤러 .>>..");
	      System.out.println(money);
	    }

	
	@GetMapping("/test")
	public  String test(Model model) {
		System.out.println("hiihi");
		String asd = "id001"; //원래는 세션영역 아이디
		
		//memberService.onelist(member.getMemberId());
		
		
		
		int totalPoint =paymentService.totalPoint();
		model.addAttribute("totalPoint", totalPoint);
		//마일리지 총값
		//한개예약리스트
		return "payment/payment";
		
	}
	
	@GetMapping("/paymentSearch")
	public String paymentSearch(Model model) {
		List<Payment> paymentList = paymentService.paymentSelect();
		
		model.addAttribute("title", "결제내역조회");
		model.addAttribute("paymentList", paymentList);
		return "payment/paymentSearch";
	}
	
	@GetMapping("/pointSearch")
	public String pointSearch(Model model) {
		 
		List<Point> pointList = paymentService.pointSelect();
		
		model.addAttribute("title", "마일리지 사용내역 조회");
		model.addAttribute("pointList", pointList);
		return "point/pointSearch";
	}
}
