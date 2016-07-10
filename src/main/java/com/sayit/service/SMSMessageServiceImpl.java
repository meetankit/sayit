package com.sayit.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import com.sayit.resources.Message;

@Service
@Slf4j
public class SMSMessageServiceImpl implements MessageService {

    private String AUTH_KEY = "118947AdUKPzi45781fc7a";
    private String SENDER = "y9KUyJ9FnRPhxR59uqAK2chYCdoA5UMAmex16VsiCSeWyh-lQfJsYNC_D6lgKDu5zf0XRS1SUQAMUvu8xTpvIDo3Wj3JHQSXk7w1XvKMtidDOmirWJKkF2sfYxinKF-VumVSssSGvaltCZnw2zGr4SuJtxQi1e6AF7qBp2fy-3Q=";
    private String ROUTE="default";
//    private String URL="https://control.msg91.com/api/sendhttp.php?";
    private String URL = "http://localhost:8080/api/mocksend?";
    
    @Override
    public void sendMessage(Message msg) throws Exception {
        //Prepare Url
        try {
            String mainUrl = buildURL(msg);
            //prepare connection
            URL myURL = new URL(mainUrl);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        } catch (IOException e) {
            log.error("Message could not be sent msg=" + msg, e);
            throw e;
        } 
    }

    private String buildURL(Message msg) {
        //encoding message 
        String encoded_message=URLEncoder.encode(msg.getMessage());

        //Prepare parameter string 
        StringBuilder sbPostData= new StringBuilder(URL);
        sbPostData.append("authkey="+AUTH_KEY); 
        sbPostData.append("&mobiles="+msg.getTo());
        sbPostData.append("&message="+encoded_message);
        sbPostData.append("&route="+ROUTE);
        sbPostData.append("&sender="+SENDER);

        //final string
        return sbPostData.toString();
    }
}
