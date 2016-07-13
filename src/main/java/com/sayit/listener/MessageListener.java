package com.sayit.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayit.resources.Message;
import com.sayit.service.MessageServiceFactory;

@Service
public class MessageListener {

    @Autowired
    private MessageServiceFactory messageServiceFactory;
    
    public void onMessage(Message message) throws Exception {
        messageServiceFactory.getMessageService(message.getType())
                    .sendMessage(message);
    }
}
