package com.coe.andaman.as.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.as.entity.User;

public interface UserService {
	
	public Optional<User> findUserById(Long id);
	
	public Optional<User> findUserByUid(String uid);
	
	public List<User> findAllUsers();
	public User createUser(User user);
	
	

}
