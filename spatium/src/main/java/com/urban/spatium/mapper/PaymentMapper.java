package com.urban.spatium.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.Payment;
import com.urban.spatium.dto.Point;



@Mapper
public interface PaymentMapper {
	
	public List<Point> pointSelect();
	
	public List<Payment> paymentSelect();
	
	
	public int paymentSystem(Payment payment);
	
	public int addPoint(Point Point);
	
	public int totalPoint();
	
	
}
