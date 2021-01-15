package com.urban.spatium.service;




import java.util.List;
import java.util.Map;

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
	
	
	public int rsvCheck(Map<String,Object> totalMap) {
		return paymentMapper.rsvCheck(totalMap);
		
	}
	
	public List<Map<String,Object>> getRsvDetailCode(String rsvCode , String dateTime){
		System.out.println("서비스오냐");
		return paymentMapper.getRsvDetailCode(rsvCode,dateTime);
		
	}
	
	public List<Payment> rsvDetail(String payCode){	
		List<Payment> list = paymentMapper.rsvDetail(payCode);
		return list;
		
	}
	
	public List<Payment> getPaymentCode(String paymentCode) {
		List<Payment> list =paymentMapper.getPaymentCode(paymentCode);
		System.out.println(list);
		
		return list;
	}
	
	public int updateState(Rsv rsv) {
		
		return paymentMapper.updateState(rsv);
	}
	
	public List<Rsv> rsvSelect(){
		List<Rsv> rsv = paymentMapper.rsvSelect();
		return rsv;
	}
	
	public Rsv rsvState(String rsvCode){
		Rsv rsv = paymentMapper.rsvState(rsvCode);
		
		return rsv;
	}
	
	public List<Point> userPointSelect(String SID){
		
		return paymentMapper.userPointSelect(SID);
	}
	
	public List<Point> pointSelect(){
		
		return paymentMapper.pointSelect();
	}
	
	public List<Payment> paymentSelect(String SID){
		
		
		return paymentMapper.paymentSelect(SID);
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
