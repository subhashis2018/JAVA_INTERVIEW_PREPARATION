package com.myapp.springbootkafkaproducer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.test.EmbeddedKafkaKraftBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.TestPropertySource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.myapp.springbootkafkaproducer.domain.LibraryEvent;
import com.myapp.springbootkafkaproducer.util.TestUtil;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EmbeddedKafka(topics = "library-event")
@TestPropertySource(properties = { "spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
		"spring.kafka.admin.properties.bootstrap.servers=${spring.embedded.kafka.brokers}" })
class LibraryEventControllerTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	ObjectMapper objectMapper;

	EmbeddedKafkaKraftBroker embeddedKafkaKraftBroker;

	private Consumer<Integer, String> consumer;

	@BeforeEach
	void setup() {
		var configs = new HashMap<>(KafkaTestUtils.consumerProps("group1", "true", embeddedKafkaKraftBroker));
		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		consumer = new DefaultKafkaConsumerFactory<Integer, String>(configs, new IntegerDeserializer(),
				new StringDeserializer()).createConsumer();
		embeddedKafkaKraftBroker.consumeFromAllEmbeddedTopics(consumer);
	}

	@AfterEach
	void tearDown() {
		consumer.close();

	}

	@Test
	void postLibraryEvent() throws JsonProcessingException {
		// Given
		LibraryEvent libraryEvent = TestUtil.libraryEventRecord();
		System.out.println("libraryEvent : " + objectMapper.writeValueAsString(libraryEvent));
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("content-type", MediaType.APPLICATION_JSON.toString());
		var httpEntity = new HttpEntity<>(TestUtil.libraryEventRecord(), httpHeaders);
		// When
		var responseEntity = restTemplate.exchange("/v1/libraryevent", HttpMethod.POST, httpEntity, LibraryEvent.class);
		// Then
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		ConsumerRecords<Integer, String> consumerRecords = KafkaTestUtils.getRecords(consumer);
		assert consumerRecords.count() == 1;
		consumerRecords.forEach(record -> {
			var libraryEventActual = TestUtil.parseLibraryEventRecord(objectMapper, record.value());
			assertEquals(libraryEvent, libraryEventActual);

		});
	}

}
