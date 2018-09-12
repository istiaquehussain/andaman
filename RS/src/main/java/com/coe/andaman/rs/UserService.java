package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface UserService {
	
	public Optional<User> findUserById(Long id);
	
	public Optional<User> findUserByUid(String uid);
	
	public List<User> findAllUsers();
	public User createUser(User user);
	
	

}
