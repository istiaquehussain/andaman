package com.coe.andaman.rs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> findUserById(Long id)
	{
		return userRepository.findById(id);
	}
	
	public Optional<User> findUserByUid(String uid)
	{
		return userRepository.findUserByUid(uid);
	}
	
	public List<User> findAllUsers()
	{
		return userRepository.findAll();
	}
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	

}
