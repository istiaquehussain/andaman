package com.coe.andaman.as.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coe.andaman.as.entity.User;

@Repository("InMemoryUserRepository")
public class InMemoryUserRepositoryImpl implements UserRepository {

	private List<User> users= new ArrayList<User>(); 
	
	@Override
	public Optional<User> findByUid(String uid) {
		// TODO Auto-generated method stub
		return users.stream().filter(user->user.getUid().equals(uid)).findFirst();
	}

	@Override
	public User save(User user) {
		users.add(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return users.stream().findFirst().filter(user->user.getId().equals(id));

	}

}
