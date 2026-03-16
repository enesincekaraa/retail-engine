package com.enesincekara.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RetailMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(RetailMonolithApplication.class, args);
    }

}
