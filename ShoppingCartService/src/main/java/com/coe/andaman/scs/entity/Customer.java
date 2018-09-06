package com.coe.andaman.scs.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@ToString
//@Entity
public class Customer {
	@Id
    @GeneratedValue
	private Long id;
	private String lName;
	private String fName;
	
	public Customer()
	{
		
	}
	public Customer(String fName,String lName)
	{
		this.lName=lName;
		this.fName=fName;
	}
}
