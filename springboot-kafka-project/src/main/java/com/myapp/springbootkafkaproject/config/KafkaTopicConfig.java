package com.myapp.springbootkafkaproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic topicString() {
		return TopicBuilder.name("kafka-string-topic").build();
	}
	
	@Bean
	public NewTopic topicJson() {
		return TopicBuilder.name("kafka-json-topic").build();
	}
}
