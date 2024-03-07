package com.myapp.springbootkafkaproducer.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myapp.springbootkafkaproducer.domain.LibraryEvent;
import com.myapp.springbootkafkaproducer.domain.LibraryEventType;
import com.myapp.springbootkafkaproducer.producer.LibraryEventProducer;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryEventController {

	@Autowired
	private final LibraryEventProducer libraryEventProducer;

	public LibraryEventController(LibraryEventProducer libraryEventProducer) {
		super();
		this.libraryEventProducer = libraryEventProducer;
	}

	@PostMapping("/v1/libraryevent")
	public ResponseEntity<?> postLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent)
			throws JsonProcessingException, InterruptedException, ExecutionException, TimeoutException {
		log.info("LibraryEvent created : ->{}", libraryEvent);
		libraryEventProducer.sendLibraryEvent_approach2(libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
	}

}
