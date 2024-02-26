package com.myapp.springbootkafkaproject.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.myapp.springbootkafkaproject.payload.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonKafkaConsumer {

	@KafkaListener(topics = "kafka-json-topic", groupId = "mygroup")
	public void consume(User user) {
		log.info(String.format("Topic received %s", user.toString()));
	}

}
