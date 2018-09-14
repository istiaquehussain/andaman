package com.coe.andaman.cs.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.cs.dao.CustomerRepository;
import com.coe.andaman.cs.entity.Address;
import com.coe.andaman.cs.entity.Customer;

@Component
public class ServiceInitializer implements CommandLineRunner{
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		loadCustomers();
		
		
	}
	
	public void loadCustomers()
	{
		Stream.of(
		new Customer("ihuss","Istiaque","Hussain",new Address("Bangalore", "India", "560029")),
		new Customer("robb","Roy","Williams",new Address("Melbourne", "Australlia", "6003")),
		new Customer("mzafar","Mirza","Zafar",new Address("Hydrabad", "India", "490029")),
		new Customer("jshell","Jessica","Shelly",new Address("California", "USA", "71005")))
		.forEach(customer->customerRepository.save(customer));
		
		System.out.println(" Cutomer DB Initialized successfully........");
	}
	
	
	
}
