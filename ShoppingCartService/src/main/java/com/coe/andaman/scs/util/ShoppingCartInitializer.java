package com.coe.andaman.scs.util;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.scs.dao.CartRepository;
import com.coe.andaman.scs.entity.Cart;

@Component
public class ShoppingCartInitializer implements CommandLineRunner{
	@Autowired
	CartRepository repository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Intializing Cart DB ........");
		Stream.of(	new Cart(1L,1L),
				new Cart(2L,3L),
				new Cart(4L,2L),
				new Cart(5L,3L)).forEach(Cart->repository.save(Cart));
	
		System.out.println(" Cart DB Initialized successfully........");
	}
	
}
