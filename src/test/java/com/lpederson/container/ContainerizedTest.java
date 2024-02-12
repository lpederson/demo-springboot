package com.lpederson.container;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

public class ContainerizedTest {

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"

    );
    ConnectionProvider connectionProvider;

    @BeforeAll
    static void beforeAll() {
        System.out.println("starting postgres");
        postgres.withDatabaseName("demo");
        postgres.withUsername("postgres");
        postgres.withPassword("postgres");
        postgres.setPortBindings(List.of("5432", "5432"));
        postgres.withCreateContainerCmdModifier(cmd -> {
            cmd.getHostConfig().withPortBindings(new PortBinding(
                    Ports.Binding.bindPort(5432), new ExposedPort(5432)));
        });
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() {
        connectionProvider = new ConnectionProvider(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
    }
}
