package com.coe.andaman.cs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coe.andaman.cs.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
