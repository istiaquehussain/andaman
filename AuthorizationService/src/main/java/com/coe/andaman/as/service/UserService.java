package com.coe.andaman.as.service;

import java.util.List;
import java.util.Optional;

import com.coe.andaman.as.entity.User;


public interface UserService {
	public void createUser(User user);
	public Optional<User> getUserById(long id);
	public Optional<User> getUserByUid(String uid);
	public List<User> getAllUsers();

}
