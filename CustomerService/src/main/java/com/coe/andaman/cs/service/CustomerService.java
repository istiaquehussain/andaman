package com.coe.andaman.cs.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.cs.entity.Customer;
//@Repository
public interface CustomerService {
	public void createCustomer(Customer customer);
	public Optional<Customer> getCutomerById(long id);
	public List<Customer> getAllCustomer();
}
