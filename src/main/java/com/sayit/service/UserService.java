package com.sayit.service;

import com.sayit.dto.User;
import com.sayit.resources.UserResource;

public interface UserService {

    Long createUser(UserResource userReg);

    User getUser(Long userId);
}