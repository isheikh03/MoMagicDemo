package com.isheikh03.moMagicDemo.chargeFailLog;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
public class ChargeFailLogRepository extends BaseRepository {
	
	public ChargeFailLogEntity save(ChargeFailLogEntity chargeFailLog) {
		return super.baseSaveOrUpdate(chargeFailLog);
	}

}
