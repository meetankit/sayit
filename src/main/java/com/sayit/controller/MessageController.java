package com.sayit.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayit.dto.User;
import com.sayit.resources.Message;
import com.sayit.resources.UserRegistrationResource;
import com.sayit.resources.UserResource;
import com.sayit.service.QueueServiceImpl;
import com.sayit.service.UserRegistrationService;
import com.sayit.service.UserService;

@RestController
public class MessageController {
    
    @Autowired
    private QueueServiceImpl queueService;
    @Autowired
    private UserRegistrationService userRegService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/v1/message/send", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(@RequestBody Message message) throws Exception {
    	queueService.publish(message);
        return "Message Sent to queue";
    }
    
    @RequestMapping(value = "/api/mocksend", method = RequestMethod.GET)
    @ResponseBody
    public String sendMockMessage() throws Exception {
        return "Mock Message Sent";
    }
    
    @RequestMapping(value = "/api/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody UserRegistrationResource userRes) throws UnsupportedEncodingException {
    	userRegService.register(userRes);
        return "Registered";
    }
    
    @RequestMapping(value = "/api/v1/user", method = RequestMethod.POST)
    @ResponseBody
    public Long createUser(@RequestBody UserResource userRes) {
    	return userService.createUser(userRes);
    }
    
    @RequestMapping(value = "/api/v1/user/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }
}
