package com.urban.spatium.mapper;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Rsv;



@Mapper
public interface PaymentMapper {
	
	public List<String> getRsvDetailCode(String rsvCode);
	
	public List<Payment> rsvDetail(String payCode);
	
	public List<Payment> getPaymentCode(String paymentCode);
	
	public int updateState(Rsv rsv);
	
	public List<Rsv> rsvSelect();
	
	public Rsv rsvState(String rsvCode);
	
	public List<Point> pointSelect();
	
	public List<Payment> paymentSelect(String SID);
	
	public int paymentSystem(Payment payment);
	
	public int addPoint(Point Point);
	
	public String totalPoint(String pointID);


	
	
}
