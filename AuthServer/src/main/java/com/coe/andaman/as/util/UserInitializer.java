package com.coe.andaman.as.util;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.as.dao.UserRepository;
import com.coe.andaman.as.entity.Role;
import com.coe.andaman.as.entity.User;

@Component
public class UserInitializer implements CommandLineRunner{
	@Autowired
	@Qualifier("InMemoryUserRepository")
	UserRepository repository;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Intializing User Account ........");
		
		Role adminRole = new Role("1","ADMIN","ADMIN","ADMIN ROLE");
		Role userRole = new Role("1","USER","USER","USER ROLE");
		
		
		Stream.of(	
				new User(1L, "hamza", "pwd", Arrays.asList(adminRole,userRole)),
				new User(2L, "boon", "pwd", Arrays.asList(adminRole)),
				new User(3L, "jupiter", "pwd", Arrays.asList(userRole)),
				new User(4L, "istiaque", "pwd", Arrays.asList(userRole)),
				new User(5L, "hussain", "pwd", Arrays.asList(adminRole,userRole)))
		
		.forEach(user->repository.save(user));
	
		System.out.println(" User Account Initialized successfully........");
	}
	
}
