package com.github.diegojose.cloud.hystrix.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HystrixService {

    private final RestTemplate restTemplate;

    private static final Logger LOGGER = Logger.getLogger(HystrixService.class.getName());

    public HystrixService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {

        URI uri = URI.create("http://localhost:8090/hystrix");
        LOGGER.log(Level.INFO, "Request fail url");
        return this.restTemplate.getForObject(uri, String.class);
    }
    public String reliable() {

        LOGGER.log(Level.INFO, "Execution Fallback method");

        return "Cloud Native Java (O'Reilly)" + LocalDate.now().toString();
    }

}
