package com.github.ricardocomar.testpyramid.eureka.client.resource;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ServiceInstanceResource {

    @Autowired
    private EurekaClient eurekaClient;

    private static final Logger LOGGER = Logger.getLogger(ServiceInstanceResource.class.getName());

    @RequestMapping("/service-instances/{applicationName}")
    public int serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
            return this.eurekaClient.getNextServerFromEureka("eurekaClientService", false).getPort();
    }

    @GetMapping("/api/musicas/{filtro}")
    public String findMusica(@PathVariable String filtro){
        LOGGER.log(Level.INFO, "Feign Client call run");
      return "Ah lek lek lek";
    }
}