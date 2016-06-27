package com.sayit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayit.resources.Message;
import com.sayit.resources.UserRegistration;
import com.sayit.service.MessageService;
import com.sayit.service.UserRegistrationService;

@RestController
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRegistrationService userRegService;

    @RequestMapping(value = "/api/v1/message/send", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(@RequestBody Message message) throws Exception {
        messageService.sendMessage(message);
        return "Message Sent";
    }
    
    @RequestMapping(value = "/api/v1/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody UserRegistration userReg) {
    	userRegService.register(userReg);
        return "Registered";
    }
}
