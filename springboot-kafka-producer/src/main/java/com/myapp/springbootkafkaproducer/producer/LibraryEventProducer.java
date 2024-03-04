package com.myapp.springbootkafkaproducer.producer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.springbootkafkaproducer.domain.LibraryEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LibraryEventProducer {

	KafkaTemplate<Integer, String> kafkaTemplate;
	ObjectMapper objectMapper;

	@Value("${spring.kafka.topic}")
	private String topic;

	public LibraryEventProducer(KafkaTemplate<Integer, String> kafkaTemplate, ObjectMapper objectMapper) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.objectMapper = objectMapper;
	}

	public CompletableFuture<SendResult<Integer, String>> sendLibraryEvent(LibraryEvent libraryEvent)
			throws JsonProcessingException {
		var key = libraryEvent.libraryEventId();
		var value = objectMapper.writeValueAsString(libraryEvent);
		var completableFuture = kafkaTemplate.send(topic, key, value);
		return completableFuture.whenComplete((sendResult, throwable) -> {
			if (throwable == null) {
				handleFailure(key, value, throwable);
			} else {
				handleSuccess(key, value, sendResult);
			}
		});

	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> sendResult) {
		log.info("Sending message for Key: {} ,and Value: {},Partition is: {}", key, value,
				sendResult.getRecordMetadata().partition());

	}

	private void handleFailure(Integer key, String value, Throwable throwable) {
		log.error("Error sending message for key: {} , value: {} and Exception occured: {}", key, value,
				throwable.getMessage());
	}

}
