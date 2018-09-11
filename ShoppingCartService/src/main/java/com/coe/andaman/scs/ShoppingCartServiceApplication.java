package com.coe.andaman.scs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingCartServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(ShoppingCartServiceApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(ShoppingCartServiceApplication.class, args);
		LOGGER.info("Shopping Cart Service Application started successfully .....");
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
