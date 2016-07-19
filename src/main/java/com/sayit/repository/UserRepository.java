package com.sayit.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayit.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Set<User> findByPhoneNo(Long phoneNo);
}
