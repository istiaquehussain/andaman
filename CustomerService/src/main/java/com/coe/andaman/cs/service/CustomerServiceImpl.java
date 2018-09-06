package com.coe.andaman.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coe.andaman.cs.dao.CustomerRepository;
import com.coe.andaman.cs.entity.Customer;
@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository repository;
	@Override
	public void createCustomer(Customer customer) {
		repository.save(customer);	
	}
	@Override
	public Optional<Customer> getCutomerById(long id) {
		return repository.findById(id);
	}
	@Override
	public List<Customer> getAllCustomer() {
		return repository.findAll();
	}

}
