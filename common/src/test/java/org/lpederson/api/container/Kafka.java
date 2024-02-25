package org.lpederson.api.container;

import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

public class Kafka {

    private final KafkaContainer kafka;

    public Kafka() {
        kafka = new KafkaContainer(
                DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
    }

    public void start() {
        kafka.start();
    }

    public void stop() {
        kafka.stop();
    }

}
