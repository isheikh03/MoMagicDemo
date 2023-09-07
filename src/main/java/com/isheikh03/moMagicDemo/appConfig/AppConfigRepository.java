package com.isheikh03.moMagicDemo.appConfig;

import org.springframework.stereotype.Repository;

import com.isheikh03.common.BaseRepository;

@Repository
public class AppConfigRepository extends BaseRepository {
	
	public AppConfigEntity findByAppName(String appName) {
		return super.baseFindOne("SELECT a FROM AppConfigEntity a where a.appName='"+appName+"'", AppConfigEntity.class);
	}

}
