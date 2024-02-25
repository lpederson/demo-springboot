package org.lpederson.backend;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


public class ContainerizedTest {

    static Postgres postgres;
    static Kafka kafka;
    ConnectionProvider pgConn;

    @BeforeAll
    static void beforeAll() {
        postgres = new Postgres();
        postgres.start();

        kafka = new Kafka();
        kafka.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
        kafka.stop();
    }

    @BeforeEach
    void setUp() {
        pgConn = postgres.connectionProvider;
    }
}
