package com.learn;

import com.learn.producer.ProducerService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KafkaBatchProcessingApplicationTests {

    @Autowired
    private ProducerService producerService;

    @Test
    @Disabled
    void contextLoads() {
    }

    @Test
    void publishingTest(){
        for(int i = 1; i <=100; i++) {
            String eventName = "Event-"+i;
            producerService.publishBatchEvents(eventName);
        }
    }

}
