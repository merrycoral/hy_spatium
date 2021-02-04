package com.urban.spatium.controller;




import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


import com.urban.spatium.dto.CancelRsv;
import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.RefundPolicy;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.service.PaymentService;
import com.urban.spatium.service.RefundService;



@Controller
public class RefundController {
	@Autowired 
	private PaymentService paymentService; 
	@Autowired 
	private RefundService refundService;
	
	
	@PostMapping("/refundBtn")
	public String refundBtn(CancelRsv cancelrsv, Point point, Payment payment,Rsv rsv,RefundPolicy refundPolicy
							,@RequestParam(name = "cancelRsvCode" , required = false)int cancelRsvCode) {
		
		System.out.println("여기기기");
		System.out.println("이거>>>"+cancelrsv);
		/*
		 * System.out.println(cancelrsv.getCancelRsvCode());
		 * System.out.println(cancelrsv.getcancelRefundPolicyCode());
		 * System.out.println(cancelrsv.getCancelReason());
		 * 
		 * System.out.println(cancelrsv.getCancelUserId());
		 * System.out.println(cancelrsv.getCancelPrice());
		 * 
		 * cancelrsv.setCancelRsvCode(cancelrsv.getCancelRsvCode());
		 * cancelrsv.setcancelRefundPolicyCode(refundPolicy.getRefundPolicyCode());
		 * cancelrsv.setCancelReason(cancelrsv.getCancelReason());
		 * cancelrsv.setCancelUserId(cancelrsv.getCancelUserId());
		 * cancelrsv.setCancelPrice(cancelrsv.getCancelPrice());
		 * cancelrsv.setCancelState("환불완료");
		 */
		int cancel = refundService.cancelRefund(cancelrsv);
		System.out.println("cancel" + cancel );
		
		
		
		System.out.println(point.getPointList()*-1 + "-<<<<<<<<<<환불되는 포인트");
		System.out.println(cancelrsv.getCancelUserId()+"-<<<<<<<<<<환불하는 아이디");
		System.out.println(point.getPointPaymentCode()+"-<<<<<<<<<<환불되는 결제코드");
		point.setPointID(cancelrsv.getCancelUserId());
		point.setPointAddList("환불 완료");
		point.setPointSellList("반환 적립");
		point.setPointList(point.getPointList()*-1);
		point.setPointPaymentCode(point.getPointPaymentCode());
		int reAddpoint = refundService.refundAddPoint(point);
		
		System.out.println(payment.getPaymentRefund()+"-<<<<<<<<<<환불되고 남은금액");
		payment.setPaymentRefund(payment.getPaymentRefund());
		payment.setPaymentRsvCode(cancelRsvCode);
		int addRePayment = refundService.refundPayment(payment);
		
		
		rsv.setRsvState("환불 완료"); 
		rsv.setRsvCode(cancelRsvCode);
		int addRsvState = refundService.refundRsv(rsv);
		
		return "index";
	}
	
	
	
	
	@GetMapping("/refundPolicy")
	public String refundPolicy(Model model,HttpSession session) {
		
		System.out.println(session.getAttribute("SID"));
		
		return "refund/refundPolicy";
	}
	//환불페이지
	@GetMapping("/refund/cancelTest")
	public String cancelTest(Model model
							,@RequestParam(name="paymentCode", required = false) String paymentCode) {
		
	
		List<Payment> cacelData = paymentService.getPaymentCode(paymentCode);
		List<Payment> payList = paymentService.rsvDetail(paymentCode);
		int storeCode =payList.get(0).getOkayStoreCode();
		System.out.println("스토어코드>>"+storeCode);
		
		List<RefundPolicy> refundPolicy =refundService.getRefundPolicy(storeCode);
		System.out.println("cacelData 여기>>>>" + cacelData);
		System.out.println("refundPolicy 여기2>>>>" + refundPolicy);
		model.addAttribute("cacelData", cacelData);
		model.addAttribute("refundPolicy", refundPolicy);
		
		return "refund/cancelPage";
	}
	//판매자 환불페이지
	@GetMapping("/refund/seller/refundSearchMyStore")
	public String refundSearchMyStore(Model model,HttpSession session) {
		String storeId = (String) session.getAttribute("SID");
		List<CancelRsv> storeRefundSelect = refundService.refundSelectStore(storeId);
		System.out.println("컨트롤러!!!!!!"+storeRefundSelect);
		model.addAttribute("refundSelect", storeRefundSelect);
		model.addAttribute("title", "환불내역조회");
		return "/refund/seller/refundSearchMyStore";
	}
	
	
	//관리자 환불페이지
	@GetMapping("/refund/admin/refundSearch")
	public String refundSearch(Model model) {
		
		List<CancelRsv> refundSelect = refundService.refundSelect();
		System.out.println("컨트롤러!!!!!!"+refundSelect);
		model.addAttribute("refundSelect", refundSelect);
		model.addAttribute("title", "환불내역조회");
		return "/refund/admin/refundSearch";
	}
}
