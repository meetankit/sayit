package com.sayit.service;

import java.io.UnsupportedEncodingException;

import com.sayit.resources.UserRegistration;

public interface UserRegistrationService {

    void register(UserRegistration userReg) throws UnsupportedEncodingException;

	String getRegistrationId(String user);
}