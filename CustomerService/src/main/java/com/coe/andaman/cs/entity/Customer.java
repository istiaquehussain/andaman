package com.coe.andaman.cs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Customer {
	@Id @GeneratedValue
	Long id;
	String uid;
	String fname;
	String lname;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "address_id")
	Address address;
	
	public Customer(String uid,String fname,String lname,Address address)
	{
		this.uid=uid;
		this.fname=fname;
		this.lname=lname;
		this.address=address;
	}

}
