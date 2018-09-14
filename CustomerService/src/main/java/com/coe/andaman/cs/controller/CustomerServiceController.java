package com.coe.andaman.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coe.andaman.cs.entity.Customer;
import com.coe.andaman.cs.service.CustomerService;
import com.coe.andaman.cs.util.CustomException;

@RestController
public class CustomerServiceController {
	@Autowired
	CustomerService customerService;
	@GetMapping("/customers/id/{id}")
	public ResponseEntity<?> findCustomerById(@PathVariable("id") Long id) throws Exception
	{
		Customer customer=customerService.findCustomerById(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Customer Not found for ID "+id));
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	@GetMapping("/customers/uid/{id}")
	public ResponseEntity<?> findCustomerByUid(@PathVariable("id") String id) throws Exception
	{
		Customer customer=customerService.findCustomerByUid(id).orElseThrow(()->new CustomException(HttpStatus.BAD_REQUEST,"Customer Not found for UID "+id));
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<?> findAllCustomers()
	{
		List<Customer> customers=customerService.findAllCustomers();
		return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
	}
	@PostMapping("/customers")
	public ResponseEntity<?> createCustomer(Customer customer)
	{
		Customer customerCreated=customerService.createCustomer(customer);
		return new ResponseEntity<>(customerCreated,HttpStatus.OK);
	}
	
	

}
