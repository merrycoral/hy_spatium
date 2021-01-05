package com.urban.spatium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.urban.spatium.dto.CalcWait;
import com.urban.spatium.mapper.CalcMapper;

@Service
@Transactional
public class CalcService {
		@Autowired
		private CalcMapper calcMapper;
		
		public List<CalcWait> getCalcWait() {
			List<CalcWait> calcWaitList = calcMapper.getCalcWait();
			return calcWaitList;
		}

}
