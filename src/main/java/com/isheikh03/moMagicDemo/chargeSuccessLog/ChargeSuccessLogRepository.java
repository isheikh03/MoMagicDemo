package com.isheikh03.moMagicDemo.chargeSuccessLog;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
public class ChargeSuccessLogRepository extends BaseRepository {
	
	public ChargeSuccessLogEntity save(ChargeSuccessLogEntity chargeSuccessLog) {
		return super.baseSaveOrUpdate(chargeSuccessLog);
	}

}
