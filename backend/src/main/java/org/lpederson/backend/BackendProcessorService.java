package org.lpederson.backend;

import org.lpederson.common.kafka.KafkaConfig;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@KafkaListener(id = "backend", topics = KafkaConfig.TOPIC)
public class BackendProcessorService {

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unknown type received: " + object);
    }
}
