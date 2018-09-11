package com.coe.andaman.ps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
@EnableResourceServer
@EnableDiscoveryClient
@EnableZuulProxy
public class ProxyServerApplication {
	private static final Logger LOGGER = LogManager.getLogger(ProxyServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProxyServerApplication.class, args);
		LOGGER.info("Proxy Server Application started successfully .....");
		
	}
}
