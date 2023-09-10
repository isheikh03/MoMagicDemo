package com.isheikh03.moMagicDemo.chargeFailLog;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
@Transactional
public class ChargeFailLogRepository extends BaseRepository {
	
	public ChargeFailLogEntity save(ChargeFailLogEntity chargeFailLog) {
		return super.baseSave(chargeFailLog);
	}

}
