package com.example.zoostorestorage.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.zoostorestorage"})
@EntityScan(basePackages = {"com.example.zoostorestorage.persistence.entities"})
@EnableJpaRepositories(basePackages = {"com.example.zoostorestorage.persistence.repositories"})
@EnableFeignClients(basePackages = {"com.example.zoostorestorage"})
public class ZooStoreStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZooStoreStorageApplication.class,args);
    }
}
