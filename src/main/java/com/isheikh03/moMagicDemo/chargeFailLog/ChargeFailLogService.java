package com.isheikh03.moMagicDemo.chargeFailLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeFailLogService {
	
	@Autowired
	private ChargeFailLogRepository chargeFailLogRepository;
	
	
	public ChargeFailLogEntity save(ChargeFailLogEntity chargeFailLog) {
		return chargeFailLogRepository.save(chargeFailLog);
	}

}
