package com.coe.andaman.as.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coe.andaman.as.dao.UserRepository;
import com.coe.andaman.as.entity.User;
@Service
public class UserServiceImpl implements UserService , UserDetailsService {
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

	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		return findUserByUid(uid).orElseThrow(()->new UsernameNotFoundException("UID not found for "+uid));
		
	}
	
	

}
