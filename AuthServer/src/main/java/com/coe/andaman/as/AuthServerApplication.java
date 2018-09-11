package com.coe.andaman.as;

import org.springframework.boot.SpringApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableDiscoveryClient
public class AuthServerApplication {
	private static final Logger LOGGER = LogManager.getLogger(AuthServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
		LOGGER.info("Auth Server Application started successfully .....");
		
	}
}
