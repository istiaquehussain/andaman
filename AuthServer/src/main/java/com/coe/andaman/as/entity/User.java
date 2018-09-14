package com.coe.andaman.as.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class User implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	Long id;
	String uid;
	String pwd;
	@OneToMany(
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
	
	@Transient
	@JsonIgnore
	List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return pwd;
	}
	@Override
	public String getUsername() {
		return uid;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
		roles.forEach(role->authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));
	}

}
