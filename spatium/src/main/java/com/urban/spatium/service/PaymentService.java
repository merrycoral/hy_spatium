package com.urban.spatium.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Rsv;
import com.urban.spatium.mapper.PaymentMapper;




@Service
@Transactional
public class PaymentService {
	// DI
	@Autowired 
	private PaymentMapper paymentMapper;
	
	public int updateState(Rsv rsv) {
		
		return paymentMapper.updateState(rsv);
	}
	
	
	public Rsv rsvState(String rsvCode){
		Rsv rsv = paymentMapper.rsvState(rsvCode);
		
		return rsv;
	}
	
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
	
	public String totalPoint(String pointID) {
		String totalPoint =  paymentMapper.totalPoint(pointID);
		System.out.println("서비스에서>>>"+pointID);
		return totalPoint;
		
	}
	


	

}
