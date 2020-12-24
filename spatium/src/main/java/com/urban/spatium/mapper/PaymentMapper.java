package com.urban.spatium.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.Rsv;



@Mapper
public interface PaymentMapper {
	
	public int updateState(Rsv rsv);
	
	public Rsv rsvState(String rsvCode);
	
	public List<Point> pointSelect();
	
	public List<Payment> paymentSelect();
	
	public int paymentSystem(Payment payment);
	
	public int addPoint(Point Point);
	
	public String totalPoint(String pointID);


	
	
}
