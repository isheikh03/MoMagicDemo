package com.isheikh03.moMagicDemo.chargeSuccessLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeSuccessLogService {
	
	@Autowired
	private ChargeSuccessLogRepository chargeSuccessLogRepository;
	
	
	public ChargeSuccessLogEntity save(ChargeSuccessLogEntity chargeSuccessLog) {
		return chargeSuccessLogRepository.save(chargeSuccessLog);
	}

}
