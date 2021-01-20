package com.kh.portfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	private static final Logger logger 
		= LoggerFactory.getLogger(HomeController.class);
	
	//메인페이지
	@GetMapping("/")
	public String welcomePage() {
		
		return "index";
	}
}







