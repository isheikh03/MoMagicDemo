package com.isheikh03.moMagicDemo.appProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AppProcessScheduler {
	
	@Autowired
	public AppProcessService appTestingService;
	
	@Scheduled(fixedDelay = 1*15*1000)//Minute*Second*Millisecond
	public void scheduleFixedDelayTask() {
		appTestingService.appProcess();
	}

}
