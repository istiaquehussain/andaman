package com.coe.andaman.rs;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
public class Cart {
	@Id @GeneratedValue
	Long id;
	Long uid;
	Long itemId;
	public Cart(Long uid, Long itemId)
	{
		this.uid=uid;
		this.itemId=itemId;
	}

}
