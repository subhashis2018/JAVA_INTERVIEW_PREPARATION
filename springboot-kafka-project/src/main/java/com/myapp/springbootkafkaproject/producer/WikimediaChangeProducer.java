package com.myapp.springbootkafkaproject.producer;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.myapp.springbootkafkaproject.handler.WikimediaChangeHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WikimediaChangeProducer {

	private KafkaTemplate<String, String> kafkaTemplate;

	public WikimediaChangeProducer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendWikimediaMessage(String message) {
		log.info(String.format("This is the topic from WIKIMEDIA %s ->", message));
		String topic = "wikimedia_change_handler";
		EventHandler eventHandler = new WikimediaChangeHandler(kafkaTemplate, topic);
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		EventSource eventSource = new EventSource.Builder(eventHandler, URI.create(url)).build();
		eventSource.start();
		try {
			TimeUnit.MINUTES.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
