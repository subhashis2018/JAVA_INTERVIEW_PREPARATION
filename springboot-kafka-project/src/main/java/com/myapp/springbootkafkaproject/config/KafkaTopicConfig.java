package com.myapp.springbootkafkaproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Value("${spring.kafka.topic.name}")
	String kafka_topic;

	@Value("${spring.kafka.topic-json.name}")
	String kafka_json_topic;

	@Value("${spring.kafka.wikimedia-topic.name}")
	String wikimedia_recent_change;

	@Bean
	public NewTopic topicString() {
		return TopicBuilder.name(kafka_topic).build();
	}

	@Bean
	public NewTopic topicJson() {
		return TopicBuilder.name(kafka_json_topic).build();
	}

	@Bean
	public NewTopic topicWikimedia() {
		return TopicBuilder.name(wikimedia_recent_change).build();
	}
}
