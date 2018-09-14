package com.coe.andaman.cs.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.cs.entity.Customer;

public interface CustomerService {
	
	
	public Optional<Customer> findCustomerById(Long id);
	
	
	public Optional<Customer> findCustomerByUid(String uid);
	
	
	public List<Customer> findAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	
	

}
