package com.learn.consumer;

import com.learn.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ConsumerService {
    private static final Logger LOG = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = Constant.SPRING_BATCH_TOPIC, groupId = "groupId")
    public void receive(@Payload List<String> messages, @Header(KafkaHeaders.OFFSET) List<Long> offsets){

        LOG.info("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        LOG.info("Starting the process to receive batch messages with size = " + messages.size());

        for (int i = 0; i < messages.size(); i++) {

            LOG.info("received message='{}' with partition-offset='{}'",
                    messages.get(i), offsets.get(i));

        }
        LOG.info("all the batch messages are consumed");
       // Thread.sleep(1000);
    }

}
