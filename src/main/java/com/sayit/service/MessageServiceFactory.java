package com.sayit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayit.resources.MessageType;

@Service
public class MessageServiceFactory {

    @Autowired
    private FCMMessageServiceImpl fcmMessageServiceImpl;
    
    @Autowired
    private SMSMessageServiceImpl smsMessageServiceImpl;
    
    public MessageService getMessageService(MessageType messageType) {
        if(messageType == MessageType.SMS) {
            return smsMessageServiceImpl;
        } else {
            return fcmMessageServiceImpl;
        }
    }
}
