package com.coe.andaman.ics.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Entity
public class Item {
	@Id
    @GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	public Item()
	{
		
	}
	public Item(String name,String description)
	{
		this.name=name;
		this.description=description;
	}

}
