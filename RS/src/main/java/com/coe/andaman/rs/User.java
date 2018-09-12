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
//@NoArgsConstructor
public class User {
	@Id @GeneratedValue
	Long id;
	String uid;
	String pwd;
	@OneToMany(
	        //mappedBy = "User", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	List<Role> roles;
	public User(String uid, String pwd, List<Role> roles)
	{
		this.uid=uid;
		this.pwd=pwd;
		this.roles=roles;
	}

}
