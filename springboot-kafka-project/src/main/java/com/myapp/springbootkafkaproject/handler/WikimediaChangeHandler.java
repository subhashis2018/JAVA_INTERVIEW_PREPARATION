package com.myapp.springbootkafkaproject.handler;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class WikimediaChangeHandler implements EventHandler {

	private KafkaTemplate<String, String> kafkaTemplate;
	private String topic;

	public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
		super();
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		log.info(String.format("This is the event from WIKIMEDIA %s -> {0} message event %s-> {1}", event,messageEvent.getData()));
		kafkaTemplate.send(topic,messageEvent.getData());
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub

	}

}
