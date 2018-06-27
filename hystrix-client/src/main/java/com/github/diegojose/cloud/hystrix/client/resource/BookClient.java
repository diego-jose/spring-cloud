package com.github.diegojose.cloud.hystrix.client.resource;

import com.github.diegojose.cloud.hystrix.client.model.CopyOfBook;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8092/", name = "findBooks")
public interface BookClient {

    @GetMapping("/api/book/{id}")
    CopyOfBook findBooks(@PathVariable("id") long id);
}
