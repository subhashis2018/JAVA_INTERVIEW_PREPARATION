package com.myapp.springbootkafkaproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	@KafkaListener(topics = "my-message", groupId = "myGroup")
	public void consume(String message) {
		log.info(String.format("Message  sent -> %s", message));

	}

}
