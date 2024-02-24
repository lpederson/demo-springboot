package org.lpederson.service;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static org.lpederson.kafka.KafkaConfig.TOPIC;

@Service
@KafkaListener(id = "backend", topics = TOPIC)
public class BackendProcessorService {

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unknown type received: " + object);
    }
}
