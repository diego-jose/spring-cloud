package com.github.diegojose.cloud.hystrix.client;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
public class ApplicationClient {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationClient.class, args);
    }
}
