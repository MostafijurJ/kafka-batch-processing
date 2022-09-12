package com.learn.producer;

import com.learn.util.Constant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProducerService {
    private final KafkaTemplate<String , String> kafkaTemplate;

    public void publishBatchEvents(String eventName){
        kafkaTemplate.send(Constant.SPRING_BATCH_TOPIC, eventName);
        log.info("publishing Batch Events to Kafka , Name: " + eventName);
    }
}
