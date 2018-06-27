package com.github.diegojose.cloud.hystrix.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder @NoArgsConstructor @AllArgsConstructor
public class CopyOfBook {

	private Long id;
	
	private String name;
	
	private String writter;
	
	private Double price;
}
