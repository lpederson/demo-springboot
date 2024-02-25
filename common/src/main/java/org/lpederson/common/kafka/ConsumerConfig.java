package org.lpederson.common.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.Properties;

import static org.lpederson.common.kafka.KafkaConfig.BOOTSTRAP_SERVER_VALUE;

@EnableKafka
@Configuration
class ConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVER_VALUE);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 20);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        return new DefaultKafkaConsumerFactory(props);
    }
}
