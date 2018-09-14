package com.coe.andaman.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coe.andaman.cs.dao.CustomerRepository;
import com.coe.andaman.cs.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	public Optional<Customer> findCustomerById(Long id)
	{
		return customerRepository.findById(id);
	}
	
	public Optional<Customer> findCustomerByUid(String uid)
	{
		return customerRepository.findCustomerByUid(uid);
	}
	
	public List<Customer> findAllCustomers()
	{
		return customerRepository.findAll();
	}
	public Customer createCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}
	
	

}
