package com.coe.andaman.scs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Cart {
	@Id @GeneratedValue
	Long id;
	Long uid;
	Long itemId;
	@Transient
	@JsonInclude(Include.NON_NULL)
	private Customer customerDeails;
	@Transient
	@JsonInclude(Include.NON_NULL)
	private Item itemDeails;
	public Cart(Long uid, Long itemId)
	{
		this.uid=uid;
		this.itemId=itemId;
	}

}
