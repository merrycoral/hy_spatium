package com.urban.spatium.service;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



import com.urban.spatium.mapper.PaymentMapper;

@Service
@Transactional
public class RefundService {
	// DI
	@Autowired 
	private PaymentMapper paymentMapper;
	
	

}
