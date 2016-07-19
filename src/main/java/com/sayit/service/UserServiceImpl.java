package com.sayit.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayit.dto.User;
import com.sayit.repository.UserRepository;
import com.sayit.resources.UserResource;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    
	@Autowired
    private UserRepository userRepository;
	
	@Override
    public void createUser(UserResource userRes) {
        log.info("Creating user="+userRes);
        User user= new User();
        user.setPhoneNo(userRes.getPhoneNo());
        user.setUserName(userRes.getUserName());
        userRepository.save(user);
                 
	}

}
