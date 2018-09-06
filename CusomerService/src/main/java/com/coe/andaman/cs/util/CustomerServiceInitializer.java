package com.coe.andaman.cs.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.cs.dao.CustomerRepository;
import com.coe.andaman.cs.entity.Customer;

@Component
public class CustomerServiceInitializer implements CommandLineRunner{
	@Autowired
	CustomerRepository repository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Intializing Customer DB ........");
		Stream.of(	new Customer("User1_FName","User1_LName"),
					new Customer("User2_FName","User2_LName"),
					new Customer("User3_FName","User3_LName"),
					new Customer("User4_FName","User4_LName"),
					new Customer("User5_FName","User5_LName")).forEach(customer->repository.save(customer));
	
		System.out.println(" Cutomer DB Initialized successfully........");
	}
	
}
