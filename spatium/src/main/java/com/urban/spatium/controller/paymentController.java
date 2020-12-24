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
import com.urban.spatium.dto.Rsv;
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
		System.out.println(PaymentRsvCode +"PaymentRsvCode의 값");
		System.out.println("유즈포인트"+(usePoint*-1));
		System.out.println("에드포인트"+addPoint);
		
		
		payment.setPaymentPrice(payment.getPaymentPrice());
		
		payment.setPaymentRsvCode(PaymentRsvCode);
		payment.setPaymentUsePoint(usePoint);
		payment.setPaymentUseMoney(payment.getPaymentUseMoney());
		payment.setPaymentAddPoint(addPoint);
		payment.setPaymentMethod("예약결제");
		payment.setPaymentIP(payment.getPaymentIP());
		int pay = paymentService.paymentSystem(payment);
		System.out.println(pay + "pay의 값");
		
		payment.getPaymentCode();// seq 추출 가능
		Point point = new Point();
		Rsv rsv = new Rsv();
		point.setPointAddList("결제 완료");
		point.setPointID(pointID);
		point.setPointSellList("마일리지 적립");
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

	
	@GetMapping("/paymentTest")
	public  String test(Model model
					,@RequestParam(name="rsvCode", required = false) String rsvCode) {
		System.out.println("hiihi");
		System.out.println(rsvCode);
		
		//memberService.onelist(member.getMemberId());
		
		Rsv rsv = paymentService.rsvState(rsvCode);
		
		model.addAttribute("rsv", rsv);
		System.out.println(rsv.getRsvUserId());
		System.out.println(rsv.getRsvCode());
		String totalPoint =paymentService.totalPoint(rsv.getRsvUserId());
		System.out.println("포인트"+totalPoint);
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
