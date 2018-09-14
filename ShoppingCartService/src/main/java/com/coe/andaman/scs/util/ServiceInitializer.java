package com.coe.andaman.scs.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.scs.dao.CartRepository;
import com.coe.andaman.scs.entity.Cart;

@Component
public class ServiceInitializer implements CommandLineRunner{
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		loadCarts();
		
	}
	
	
	public void loadCarts()
	{
		Stream.of(
		new Cart(1L,3L),
		new Cart(3L,3L),
		new Cart(3L,5L),
		new Cart(5L,2L),
		new Cart(5L,1L),
		new Cart(7L,5L))
		.forEach(cart->cartRepository.save(cart));
		System.out.println(" Cart DB Initialized successfully........");
	}
	
}
