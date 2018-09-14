package com.coe.andaman.scs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;

@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Address {
	@Id @GeneratedValue
	Long id;
	String city;
	String country;
	String zip;
	public Address(String city, String country,String zip)
	{
		this.city=city;
		this.country=country;
		this.zip=zip;
	}

}
