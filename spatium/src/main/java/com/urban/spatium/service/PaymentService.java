package com.urban.spatium.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.mapper.PaymentMapper;




@Service
@Transactional
public class PaymentService {
	// DI
	@Autowired 
	private PaymentMapper paymentMapper;
	
	
	public List<Point> pointSelect(){
		
		return paymentMapper.pointSelect();
	}
	
	public List<Payment> paymentSelect(){
		
		
		return paymentMapper.paymentSelect();
	}
	
	public int paymentSystem(Payment payment) {
		
		int pay = paymentMapper.paymentSystem(payment);
		
	
		return pay;
	}
	
	public int addPoint(Point Point) {
		
	int result	= paymentMapper.addPoint(Point);
		return result;
		
	}
	
	public int totalPoint() {
		int totalPoint =  paymentMapper.totalPoint();
		return totalPoint;
		
	}
	


	

}
