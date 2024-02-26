package com.myapp.springbootkafkaproject.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.myapp.springbootkafkaproject.payload.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class JsonKafkaProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		log.info(String.format("Data  sent -> %s", data.toString()));
		Message<User> message=MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "kafka-json-topic").build();
		kafkaTemplate.send(message);
	}
}
