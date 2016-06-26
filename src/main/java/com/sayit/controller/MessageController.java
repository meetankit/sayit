package com.sayit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sayit.resources.Message;
import com.sayit.service.MessageService;

@RestController
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/api/v1/message/send", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(@RequestBody Message message) throws Exception {
        messageService.sendMessage(message);
        return "Message Sent";
    }
}
