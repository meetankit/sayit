package com.sayit.service;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.sayit.resources.UserRegistration;

@Service
@Slf4j
public class UserRegistrationServiceImpl implements UserRegistrationService {
    
	private Map<String, String> userRegistrations = new HashMap<String, String>();
	
    @Override
    public void register(UserRegistration userReg) {
        log.info("Saving userReg="+userReg);
        userRegistrations.put(userReg.getUser(), userReg.getRegId());
    }

    @Override
    public String getRegistrationId(String user) {
    	return userRegistrations.get(user);
	}
}
