package com.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		log.info("Logging working");
		return "HELLO";
	}

}
