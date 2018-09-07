package com.coe.andaman.scs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	@JsonInclude(Include.NON_NULL)
	private Customer customerDeails;
	@Transient
	@JsonInclude(Include.NON_NULL)
	private Item itemDeails;
	
	public Cart()
	{
		
	}
	public Cart(Long userId,Long itemId)
	{
		this.userId=userId;
		this.itemId=itemId;
	}

}
