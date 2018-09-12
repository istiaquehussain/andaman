package com.coe.andaman.rs;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Customer {
	@Id @GeneratedValue
	Long id;
	String uid;
	String fname;
	String lname;
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
	Address address;
	
	public Customer(String uid,String fanme,String lname,Address address)
	{
		this.uid=uid;
		this.fname=fname;
		this.lname=lname;
		this.address=address;
	}

}
