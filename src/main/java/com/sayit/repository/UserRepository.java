package com.sayit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayit.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
