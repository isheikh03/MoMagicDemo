package com.isheikh03.moMagicDemo.chargeSuccessLog;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
@Transactional
public class ChargeSuccessLogRepository extends BaseRepository {
	
	public ChargeSuccessLogEntity save(ChargeSuccessLogEntity chargeSuccessLog) {
		return super.baseSave(chargeSuccessLog);
	}

}
