package org.lpederson.backend;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;
import com.github.dockerjava.api.model.Ports;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

public class Postgres {

    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );
    ConnectionProvider connectionProvider;

    public void start() {
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

        connectionProvider = new ConnectionProvider(
                postgres.getJdbcUrl(),
                postgres.getUsername(),
                postgres.getPassword()
        );
    }

    public void stop() {
        postgres.stop();
    }
}
