package com.myapp.springbootkafkaproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome.message}")
	String message;

	@GetMapping("/hello")
	public String sayHello() {
		return message;
	}

}
