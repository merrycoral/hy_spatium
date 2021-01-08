package com.urban.spatium.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.CancelRsv;
import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.RefundPolicy;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.dto.Store;
import com.urban.spatium.mapper.PaymentMapper;
import com.urban.spatium.mapper.RefundMapper;

@Service
@Transactional
public class RefundService {
	// DI
	@Autowired 
	private RefundMapper refundMapper;
	
	
	
	public List<CancelRsv> refundSelect(){
		List<CancelRsv> refundselect = refundMapper.refundSelect();
		System.out.println("서비스!!!!!!!");
		return  refundselect;
	}
	
	public int refundRsv(Rsv rsv) {
		
		return refundMapper.refundRsv(rsv);
	}
	
	public int refundPayment(Payment paymnet) {
		
		return refundMapper.refundPayment(paymnet);
	}
	
	public int refundAddPoint(Point point) {
		
		return refundMapper.refundAddPoint(point);
	}
	
	public int cancelRefund(CancelRsv cancelrsv) {
		int refund = refundMapper.cancelRefund(cancelrsv);
		return refund;
	}
	
	public List<RefundPolicy> getRefundPolicy(int storeCode){
		
		return refundMapper.getRefundPolicy(storeCode);	
	}
	
	public String addRefundPolicy(Map<String, Object> rePolicyMap) {
		System.out.println("서비스체크");
		String result = "환불정책 등록 실패";
		if(refundMapper.addRefundPolicy((Store) rePolicyMap)>0) {
			result = "환불정책 등록 성공";
		}
		return result;	
	}
	
}
