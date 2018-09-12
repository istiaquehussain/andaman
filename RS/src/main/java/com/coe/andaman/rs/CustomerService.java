package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface CustomerService {
	
	
	public Optional<Customer> findCustomerById(Long id);
	
	
	public Optional<Customer> findCustomerByUid(String uid);
	
	
	public List<Customer> findAllCustomers();
	
	public Customer createCustomer(Customer customer);
	
	
	

}
