package com.isheikh03.moMagicDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isheikh03.moMagicDemo.service.AppTestingService;

@RestController
@RequestMapping("/testing")
public class TestController {
	
	@Autowired
	public AppTestingService appTestingService;
	
	@GetMapping("/app")
	public String update(@RequestBody(required = false) String reqObj) {
		
		appTestingService.run();

		return "Test Api Success";
	}

}
