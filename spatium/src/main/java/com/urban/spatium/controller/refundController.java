package com.urban.spatium.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.RefundPolicy;
import com.urban.spatium.service.PaymentService;
import com.urban.spatium.service.RefundService;



@Controller
public class refundController {
	@Autowired 
	private PaymentService paymentService; 
	@Autowired 
	private RefundService refundService;
	
	
	
	@RequestMapping(value = "/refundPolicy", produces="application/json"  ,method = RequestMethod.POST ) 
	   public @ResponseBody String addRefundPolicy(@RequestBody RefundPolicy refundPolicy) {
		  System.out.println(refundPolicy);
	      Map<String, Object> rePolicyMap = new HashMap<String, Object>();
	      rePolicyMap.put("list", refundPolicy.getRefundPolicyList());
	      System.out.println("리스트체크>>"+refundPolicy.getRefundPolicyList());
	      refundService.addRefundPolicy(rePolicyMap);
	
	      
	      return "refundPolicy"; 
	   }
	
	@GetMapping("/refundPolicy")
	public String refundPolicy(Model model,HttpSession session) {
		
		System.out.println(session.getAttribute("SID"));
		
		return "refund/refundPolicy";
	}
	
	@GetMapping("/cancelTest")
	public String cancelTest(Model model
							,@RequestParam(name="paymentCode", required = false) String paymentCode) {
		List<Payment>  payment = paymentService.getPaymentCode(paymentCode);
		 
		
		model.addAttribute("payment", payment);
		
		return "refund/cancelPage";
	}
	
	
	@GetMapping("/refundSearch")
	public String refundSearch(Model model) {
		
		
		model.addAttribute("title", "환불내역조회");
		return "refund/refundSearch";
	}
}
