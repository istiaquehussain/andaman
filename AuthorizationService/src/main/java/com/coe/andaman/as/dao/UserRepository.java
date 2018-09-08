package com.coe.andaman.as.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coe.andaman.as.entity.User;

//public interface UserRepository extends JpaRepository<User, Long> {

public interface UserRepository {

	Optional<User> findByUid(String uid);
	
	User save(User user) ;
	
	List<User> findAll() ;
	
	Optional<User> findById(Long id);

}
