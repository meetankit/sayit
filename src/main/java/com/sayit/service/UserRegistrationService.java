package com.sayit.service;

import com.sayit.resources.UserRegistration;

public interface UserRegistrationService {

    void register(UserRegistration userReg);

	String getRegistrationId(String user);
}