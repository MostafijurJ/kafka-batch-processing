package com.learn.config;

import com.learn.util.Constant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic uploadTopic(){

        return TopicBuilder
                .name(Constant.SPRING_BATCH_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }



}
