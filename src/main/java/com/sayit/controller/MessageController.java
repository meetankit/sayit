package com.sayit.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayit.resources.Message;
import com.sayit.resources.UserRegistration;
import com.sayit.service.MessageServiceFactory;
import com.sayit.service.UserRegistrationService;

@RestController
public class MessageController {
    
    @Autowired
    private MessageServiceFactory messageServiceFactory;
    @Autowired
    private UserRegistrationService userRegService;

    @RequestMapping(value = "/api/v1/message/send", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(@RequestBody Message message) throws Exception {
        messageServiceFactory.getMessageService(message.getType()).sendMessage(message);
        return "Message Sent";
    }
    
    @RequestMapping(value = "/api/mocksend", method = RequestMethod.GET)
    @ResponseBody
    public String sendMockMessage() throws Exception {
        return "Mock Message Sent";
    }
    
    @RequestMapping(value = "/api/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody UserRegistration userReg) throws UnsupportedEncodingException {
    	userRegService.register(userReg);
        return "Registered";
    }
}
