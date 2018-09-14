package com.coe.andaman.as.util;

import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.coe.andaman.as.dao.UserRepository;
import com.coe.andaman.as.entity.Role;
import com.coe.andaman.as.entity.User;

@Component
public class ServiceInitializer implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		loadUsers();
		
	}
	
	
	public void loadUsers()
	{
		Stream.of(new User("ihuss","pwd",Arrays.asList(new Role("USER"))),
				new User("robb","pwd",Arrays.asList(new Role("USER"))),
				new User("mzafar","pwd",Arrays.asList(new Role("USER"))),
				new User("jshell","pwd",Arrays.asList(new Role("USER"))),
				new User("admin","pwd",Arrays.asList(new Role("USER"),new Role("ADMIN"))),
				new User("dba","pwd",Arrays.asList(new Role("DBA")))
				).forEach(user->userRepository.save(user));
		
		
		System.out.println(" User DB Initialized successfully........");
	}
	
	
}
