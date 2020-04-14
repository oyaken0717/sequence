package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.TestService;

@Controller
@RequestMapping("")
public class TestContoller {
		
	@Autowired
	private TestService testService;
	
	@RequestMapping("")
	public String toStart() {
		
		return "start";
	}
	
	@RequestMapping("/finish")
	public String finish() {
		testService.insert();
		return "finish";
	}
}
