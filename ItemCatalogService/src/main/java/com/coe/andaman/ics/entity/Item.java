package com.coe.andaman.ics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Item {
	@Id @GeneratedValue
	Long id;
	String brand;
	String description;
	
	
	public Item(String brand,String description)
	{
		this.brand=brand;
		this.description=description;
	}

}
