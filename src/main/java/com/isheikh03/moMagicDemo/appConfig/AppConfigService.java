package com.isheikh03.moMagicDemo.appConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppConfigService {
	
	@Autowired
	private AppConfigRepository appConfigRepository;
	
	public AppConfigEntity findAppConfig() {
		return appConfigRepository.findByAppName("cgw_v1");
	}

}
