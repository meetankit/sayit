package com.sayit.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    public void register(UserRegistration userReg) throws UnsupportedEncodingException {
        log.info("Saving userReg="+userReg);
        userRegistrations.put(userReg.getUser(), 
                URLDecoder.decode(userReg.getRegId(), "UTF-8").replace("https://android.googleapis.com/gcm/send/", ""));
    }

    @Override
    public String getRegistrationId(String user) {
    	return userRegistrations.get(user);
	}
}
