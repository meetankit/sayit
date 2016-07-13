package com.sayit.service;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Queues;
import com.sayit.listener.MessageListener;
import com.sayit.listener.MessageListenerTask;
import com.sayit.resources.Message;

@Service
public class QueueServiceImpl implements QueueService {
    
    private Queue<Message> queue = Queues.newLinkedBlockingQueue();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    
    @Autowired
    private MessageListener messageListener;
    
    @PostConstruct
    public void postConstruct() {
        MessageListenerTask task = new MessageListenerTask(queue, messageListener);
        executor.scheduleWithFixedDelay(task, 5, 5, TimeUnit.SECONDS);
    }
    
    @Override
    public void publish(Message message) throws IOException {
        queue.add(message);
    }
    
}