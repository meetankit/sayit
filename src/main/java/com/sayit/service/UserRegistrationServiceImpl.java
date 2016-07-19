package com.sayit.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayit.dto.UserRegistration;
import com.sayit.repository.UserRegistrationRepository;
import com.sayit.resources.UserRegistrationResource;

@Service
@Slf4j
public class UserRegistrationServiceImpl implements UserRegistrationService {
    	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	@Override
    public void register(UserRegistrationResource userRes) throws UnsupportedEncodingException {
        log.info("Saving userReg="+userRes);
         
        userRes.setRegId(URLDecoder.decode(userRes.getRegId(), "UTF-8").replace("https://android.googleapis.com/gcm/send/", ""));

        UserRegistration userRegistration = userRegistrationRepository.findOne(userRes.getPhoneNo());
        if(userRegistration == null) {
        	userRegistration = new UserRegistration();
        }
        userRegistration.setRegId(userRes.getRegId());
        userRegistration.setPhoneNo(Long.valueOf(userRes.getPhoneNo()));
        userRegistrationRepository.save(userRegistration);              
	}
	
    @Override
    public String getRegistrationId(Long phoneNo) {
    	return userRegistrationRepository.findOne(phoneNo).getRegId();
	}
}
