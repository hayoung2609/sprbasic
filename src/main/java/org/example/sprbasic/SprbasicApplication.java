package org.example.sprbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SprbasicApplication {
    public static void main(String[] args) {
        SpringApplication.run(SprbasicApplication.class, args);
    }

}
