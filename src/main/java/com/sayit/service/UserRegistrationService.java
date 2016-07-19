package com.sayit.service;

import java.io.UnsupportedEncodingException;

import com.sayit.resources.UserResource;

public interface UserRegistrationService {

    void register(UserResource userReg) throws UnsupportedEncodingException;

	String getRegistrationId(Long phoneNo);
}