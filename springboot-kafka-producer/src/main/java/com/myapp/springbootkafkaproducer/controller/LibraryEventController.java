package com.myapp.springbootkafkaproducer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.springbootkafkaproducer.domain.LibraryEvent;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class LibraryEventController {

	public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) {
		log.info("libraryEvent : {}" + libraryEvent);
		return ResponseEntity.status(HttpStatus.CREATED).body(libraryEvent);
	}

}
