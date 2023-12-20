package com.nanagims.foodies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@EnableJpaRepositories(value = {"com.nanagims.foodies.repository"})
public class FoodiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodiesApplication.class, args);
    }

}

