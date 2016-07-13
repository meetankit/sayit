package com.sayit.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayit.resources.Message;

@Service
public class QueueSendFactory
{
 private static List<Message> sendQueue;
 @Autowired
 private FCMMessageServiceImpl fcmMessageServiceImpl;
 
 @Autowired
 private SMSMessageServiceImpl smsMessageServiceImpl;
 @Autowired
 private MessageServiceFactory messageServiceFactory;

 public void sentToQueue(Message message)
    throws IOException//, JMSException
 {
	 sendQueue.add(message);
 }
 
 public void sendMessage(List<Message> sendQueue)
		    throws Exception
{
	 int index=0;
	 while(!sendQueue.get(index).equals(null))
	 {
		Message tempMessage;
		tempMessage=sendQueue.get(index);
		messageServiceFactory.getMessageService(tempMessage.getType()).sendMessage(tempMessage);
	 	index++;
	 }
	 
   }

}