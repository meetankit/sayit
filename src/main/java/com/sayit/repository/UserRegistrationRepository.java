package com.sayit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayit.dto.UserRegistration;

public interface UserRegistrationRepository extends JpaRepository<UserRegistration, Long> {
}
