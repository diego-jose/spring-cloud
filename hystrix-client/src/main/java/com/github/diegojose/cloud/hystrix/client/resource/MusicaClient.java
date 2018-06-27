package com.github.diegojose.cloud.hystrix.client.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:9090", name = "findMusica")
public interface MusicaClient {

    @GetMapping("/api/musicas/{filtro}")
    String findMusica(@PathVariable("filtro") String filtro);
}
