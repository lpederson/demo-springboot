package org.lpederson.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories({"org.lpederson.common.repository"})
@EntityScan("org.lpederson.common")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
