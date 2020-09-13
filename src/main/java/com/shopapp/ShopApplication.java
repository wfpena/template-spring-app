package com.shopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EntityScan("com.shopapp.model")
@SpringBootApplication
public class ShopApplication {
    
    private static final Logger LOG = LoggerFactory.getLogger(ShopApplication.class);

    public static void main(String[] args) {
        LOG.info("Starting Sprint Template Application");
        SpringApplication.run(ShopApplication.class, args);
    }
}
