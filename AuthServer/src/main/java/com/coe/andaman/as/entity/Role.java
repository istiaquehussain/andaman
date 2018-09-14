package com.coe.andaman.as.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor
public class Role {
	@Id @GeneratedValue
	Long id;
	String name;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    User user;
	public Role(String name)
	{
		this.name=name;
	}
	

}
