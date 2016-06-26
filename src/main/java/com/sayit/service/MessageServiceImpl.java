package com.sayit.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.sayit.resources.Message;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Override
    public void sendMessage(Message message) {
        log.info("Sending message="+message);
    }

}
