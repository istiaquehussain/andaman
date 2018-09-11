package com.coe.andaman.ics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@SpringBootApplication
@EnableDiscoveryClient
public class ItemCatalogServiceApplication {
	private static final Logger LOGGER = LogManager.getLogger(ItemCatalogServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ItemCatalogServiceApplication.class, args);
		LOGGER.info("Item Catalog Service Application started successfully .....");
		
	}
}
