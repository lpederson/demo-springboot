package org.lpederson.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import static org.lpederson.kafka.KafkaConfig.BOOTSTRAP_SERVER_VALUE;



import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ProducerConfig {
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVER_VALUE);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 20);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return new DefaultKafkaProducerFactory(props);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
