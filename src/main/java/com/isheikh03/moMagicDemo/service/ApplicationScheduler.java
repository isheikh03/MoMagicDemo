package com.isheikh03.moMagicDemo.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ApplicationScheduler {
	
	@Autowired
	public AppTestingService appTestingService;
	
	@Scheduled(fixedDelay = 1*60*1000)
	public void scheduleFixedRateTask() {
		appTestingService.run();
	    System.out.println("Fixed rate task - " + new Date());
	}

}
