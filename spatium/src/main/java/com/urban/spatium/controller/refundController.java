package com.urban.spatium.controller;



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
import com.urban.spatium.dto.RefundPolicy;
import com.urban.spatium.service.PaymentService;
import com.urban.spatium.service.RefundService;



@Controller
public class refundController {
	@Autowired 
	private PaymentService paymentService; 
	private RefundService refundService;
	

	@RequestMapping(value = "/testAjax", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String testAjax(@RequestBody RefundPolicy refund  ){
		
		System.out.println("hihihii");
		System.out.println(refund.getRefundPolicyStoreCode());
		System.out.println(refund.getRefundPolicyUserId());
		System.out.println(refund.getRemainingDay());
		System.out.println(refund.getRefundPercent());
		
		
		
		
		return "";
	}
	
	@PostMapping("/refundTest")
	public String refundTest(Model model,RefundPolicy refund
							,@RequestParam(name = "refundPolicyStoreCode", required = false)String refundPolicyStoreCode
							,@RequestParam(name = "remainingDay", required = false)String remainingDay
							,@RequestParam(name = "refundPercent", required = false)String refundPercent
							,@RequestParam(name = "refundPolicyUserId", required = false)String refundPolicyUserId) {
		System.out.println("hihihihi");
		System.out.println(refundPolicyStoreCode);
		System.out.println(remainingDay);
		System.out.println(refundPercent);
		System.out.println(refundPolicyUserId);
		
		return "/";
	}
	
	@GetMapping("/refundPolicy")
	public String refundPolicy(Model model) {
		return "refund/refundPolicy";
	}
	
	@GetMapping("/cancelTest")
	public String cancelTest(Model model
							,@RequestParam(name="paymentCode", required = false) String paymentCode) {
		Payment payment = paymentService.getPaymentCode(paymentCode);
		
		model.addAttribute("payment", payment);
		
		return "refund/cancelPage";
	}
	
	
	@GetMapping("/refundSearch")
	public String refundSearch(Model model) {
		
		
		model.addAttribute("title", "환불내역조회");
		return "refund/refundSearch";
	}
}
