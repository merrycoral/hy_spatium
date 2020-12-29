package com.urban.spatium.mapper;	





import java.util.Map;	

import org.apache.ibatis.annotations.Mapper;	



@Mapper	
public interface RefundMapper {	

	public int addRefundPolicy(Map<String, Object> rePolicyMap);	


}