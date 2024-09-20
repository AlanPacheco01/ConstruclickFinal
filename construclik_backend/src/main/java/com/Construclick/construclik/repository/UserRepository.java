package com.Construclick.construclik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Construclick.construclik.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	
	
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 ")
	User findByEmail(String email);
}
