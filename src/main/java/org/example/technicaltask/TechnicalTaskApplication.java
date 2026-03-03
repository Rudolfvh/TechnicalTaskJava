package org.example.technicaltask;

import org.example.technicaltask.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class TechnicalTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechnicalTaskApplication.class, args);
    }

}
