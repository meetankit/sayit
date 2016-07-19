package com.sayit.service;

import java.io.UnsupportedEncodingException;

import com.sayit.resources.UserRegistrationResource;

public interface UserRegistrationService {

    void register(UserRegistrationResource userReg) throws UnsupportedEncodingException;

	String getRegistrationId(Long phoneNo);
}