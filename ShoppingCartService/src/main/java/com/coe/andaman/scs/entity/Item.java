package com.coe.andaman.scs.entity;

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
