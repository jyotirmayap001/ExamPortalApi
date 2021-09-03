package com.examportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByemail(String email);
	
	public User findByusername(String username);
}
