package com.myapp.springbootkafkaproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootkafkaproject.payload.User;
import com.myapp.springbootkafkaproject.producer.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
	//@Autowired
	JsonKafkaProducer jsonKafkaProducer;

	
	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
		this.jsonKafkaProducer = jsonKafkaProducer;
	}
	
	
	// http:localhost:8080/api/v1/kafka/publish?message=hello world
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user){
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("JSON Message sent to kafka topic");
	}
	

}
