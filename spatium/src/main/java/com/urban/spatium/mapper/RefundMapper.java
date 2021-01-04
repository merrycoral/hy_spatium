package com.urban.spatium.mapper;	





import java.util.List;
import java.util.Map;	

import org.apache.ibatis.annotations.Mapper;

import com.urban.spatium.dto.CancelRsv;
import com.urban.spatium.dto.Point;
import com.urban.spatium.dto.RefundPolicy;	



@Mapper	
public interface RefundMapper {	

	public int refundAddPoint(Point point);
	
	public int cancelRefund(CancelRsv cancelrsv);
	
	public List<RefundPolicy> getRefundPolicy(int storeCode);	
	
	public int addRefundPolicy(Map<String, Object> rePolicyMap);	


}