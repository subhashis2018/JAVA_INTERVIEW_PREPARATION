package com.myapp.kaproducer.producer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.kafkaproducer.domain.LibraryEvent;

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

	// Recommended asynchronous approach

	public CompletableFuture<SendResult<Integer, String>> sendLibraryEvent_approach1(LibraryEvent libraryEvent) throws JsonProcessingException {
		var key = libraryEvent.libraryEventId();
		var value = objectMapper.writeValueAsString(libraryEvent);
		// 1 : blocking call, get metadata about kafka cluster
		// 2: send message happens, returns a completable future
		var completableFuture = kafkaTemplate.send(topic, key, value);
		return completableFuture.whenComplete((sendResult, throwable) -> {
			if (throwable == null) {
				handleFailure(key, value, throwable);
			} else {
				handleSuccess(key, value, sendResult);
			}
		});

	}

	public SendResult<Integer, String> sendLibraryEvent_approach2(LibraryEvent libraryEvent)
			throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException {
		var key = libraryEvent.libraryEventId();
		var value = objectMapper.writeValueAsString(libraryEvent);
		// 1 : blocking call, get metadata about kafka cluster
		// 2: Block and wait until the message is sent to kafka
		var sendResult = kafkaTemplate.send(topic, key, value)
				// get()
				.get(3, TimeUnit.SECONDS);
		handleSuccess(key, value, sendResult);
		return sendResult;
	}

	// Recomended asynchronous approach

	public CompletableFuture<SendResult<Integer, String>> sendLibraryEvent_approach3(LibraryEvent libraryEvent) throws JsonProcessingException {
		var key = libraryEvent.libraryEventId();
		var value = objectMapper.writeValueAsString(libraryEvent);

		var producerRecord = buildProduceRecord(key, value);
		// 1 : blocking call, get metadata about kafka cluster
		// 2: send message happens, returns a completable future
		var completableFuture = kafkaTemplate.send(producerRecord);
		return completableFuture.whenComplete((sendResult, throwable) -> {
			if (throwable == null) {
				handleFailure(key, value, throwable);
			} else {
				handleSuccess(key, value, sendResult);
			}
		});

	}

	private ProducerRecord<Integer, String> buildProduceRecord(Integer key, String value) {
		List<Header> recordHeader = List.of(new RecordHeader("event-source", "scanner".getBytes()));
		return new ProducerRecord<>(topic, null, key, value, recordHeader);
	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> sendResult) {
		log.info("Sending message for Key: {} ,and Value: {},Partition is: {}", key, value, sendResult.getRecordMetadata().partition());
	}

	private void handleFailure(Integer key, String value, Throwable throwable) {
		log.error("Error sending message for key: {} , value: {} and Exception occured: {}", key, value, throwable.getMessage());
	}

}
