package com.coe.andaman.scs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Entity
public class Cart {
	@Id
    @GeneratedValue
	private Long id;
	private Long userId;
	private Long itemId;
	@Transient
	private Customer customerDeails = new Customer();
	@Transient
	private Item itemDeails = new Item();
	
	public Cart()
	{
		
	}
	public Cart(Long userId,Long itemId)
	{
		this.userId=userId;
		this.itemId=itemId;
	}

}
