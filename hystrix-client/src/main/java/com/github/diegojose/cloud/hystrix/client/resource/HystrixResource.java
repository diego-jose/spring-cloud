package com.github.diegojose.cloud.hystrix.client.resource;

import com.github.diegojose.cloud.hystrix.client.model.CopyOfBook;
import com.github.diegojose.cloud.hystrix.client.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api")
public class HystrixResource {

    @Autowired
    private HystrixService hystrixService;

    @Autowired
    private MusicaClient musicaClient;

    @Autowired
    private BookClient bookClient;

    @Bean
    public RestTemplate rest(RestTemplateBuilder builder) {
        return builder.build();
    }

    private static final Logger LOGGER = Logger.getLogger(HystrixResource.class.getName());

    @GetMapping("/to-read")
    public String readingList() {
        LOGGER.log(Level.INFO, "Call FallBack Hystrix...");
        return hystrixService.readingList();
    }

    @GetMapping("/to-read-error")
    public String feing() {
        LOGGER.log(Level.INFO, "Call Feing Client...");
        return musicaClient.findMusica("Iron");
    }


    @GetMapping("to-find-book/{id}")
    public CopyOfBook findBook(@PathVariable("id") long id)  {
        LOGGER.log(Level.INFO, "Call Feing Client...");
        return bookClient.findBooks(id);
    }

    @GetMapping("to-find-music")
    @HystrixCommand(fallbackMethod = "circuit")
    public String findMusic(){
        LOGGER.log(Level.INFO, "Call Hystrix open circuit...");
        return musicaClient.findMusica("Iron");
    }

    public String circuit(){
        return "No service active";
    }


}
