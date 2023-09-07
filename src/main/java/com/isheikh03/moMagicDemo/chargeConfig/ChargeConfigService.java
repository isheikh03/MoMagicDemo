package com.isheikh03.moMagicDemo.chargeConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargeConfigService {
	
	@Autowired
	private ChargeConfigRepository chargeConfigRepository;
	
	public ChargeConfigEntity findByChargeCode(String chargeCode) {
		return chargeConfigRepository.findByChargeCode(chargeCode);
	}
	public ChargeConfigEntity findByPrice(int price) {
		return chargeConfigRepository.findByPrice(price);
	}

}
