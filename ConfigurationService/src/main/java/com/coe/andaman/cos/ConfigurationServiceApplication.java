package com.coe.andaman.cos;

import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(ConfigurationServiceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServiceApplication.class, args);
		LOGGER.info("Configuration Service Application started successfully .....");
		
	}
}
