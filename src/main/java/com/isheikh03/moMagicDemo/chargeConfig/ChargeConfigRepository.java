package com.isheikh03.moMagicDemo.chargeConfig;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
public class ChargeConfigRepository extends BaseRepository {
	
	public ChargeConfigEntity findByChargeCode(String chargeCode) {
		return super.baseFindOne("SELECT c FROM ChargeConfigEntity c where c.chargeCode='"+chargeCode+"'", ChargeConfigEntity.class);
	}
	
	public ChargeConfigEntity findByPrice(int price) {
		return super.baseFindOne("SELECT c FROM ChargeConfigEntity c where c.price="+price, ChargeConfigEntity.class);
	}

}
