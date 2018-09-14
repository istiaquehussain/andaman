package com.coe.andaman.as.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.andaman.as.entity.User;
import com.coe.andaman.as.service.UserService;
import com.coe.andaman.as.util.CustomException;

@RestController
public class AuthServerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user")
	public Principal getUser(Principal ps) {
		return ps;
	}
	
	
	@GetMapping("/users/id/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") Long id) throws Exception
	{
		User user=userService.findUserById(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Customer Not found for ID "+id));
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	@GetMapping("/users/uid/{id}")
	public ResponseEntity<?> findCustomerByUid(@PathVariable("id") String id) throws Exception
	{
		User user=userService.findUserByUid(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Customer Not found for UID "+id));
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/users")
	public ResponseEntity<?> findAllCustomers()
	{
		List<User> user=userService.findAllUsers();
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
	}
	@PostMapping("/users")
	public ResponseEntity<?> createCustomer(User user)
	{
		User customerCreated=userService.createUser(user);
		return new ResponseEntity<>(customerCreated,HttpStatus.OK);
	}

}
