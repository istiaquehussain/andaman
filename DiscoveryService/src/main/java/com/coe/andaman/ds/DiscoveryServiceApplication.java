package com.coe.andaman.ds;

import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(DiscoveryServiceApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(DiscoveryServiceApplication.class, args);
		LOGGER.info("Discovery  Service Application started successfully .....");
		
	}
}
