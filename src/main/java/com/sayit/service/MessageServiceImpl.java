package com.sayit.service;

import java.net.URI;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;
import com.sayit.resources.FCMMessage;
import com.sayit.resources.Message;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {
    
    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "https://android.googleapis.com/gcm/send";
    private final String KEY = "AIzaSyCnI7WKD0DN8vzzW-bO5tahEclRLmA-Jsw";
    
    @Override
    public void sendMessage(Message message) throws Exception {
        log.info("Sending message="+message);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "key=" + KEY);
        headers.add("Content-Type", "application/json");
        FCMMessage fcmMessage = new FCMMessage();
        fcmMessage.setRegistration_ids(Lists.newArrayList(message.getFrom()));
        RequestEntity<FCMMessage> requestEntity = 
                new RequestEntity<FCMMessage>(fcmMessage, headers, HttpMethod.POST, new URI(URL));
        restTemplate.exchange(requestEntity, Map.class);
    }

}
