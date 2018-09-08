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
public class UserServiceImpl implements UserService, UserDetailsService {

	
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
		return getUserByUid(uid).orElseThrow(()->new UsernameNotFoundException("UID not found for "+uid));
	}

	@Override
	public void createUser(User user) {
		UserRepository.save(user);
		
	}

	@Override
	public Optional<User> getUserById(long id) {
		return UserRepository.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}

	@Override
	public Optional<User> getUserByUid(String uid) {
		return UserRepository.findByUid(uid);
	}

	
}
