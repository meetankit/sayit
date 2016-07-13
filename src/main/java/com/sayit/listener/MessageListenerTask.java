package com.sayit.listener;

import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

import com.sayit.resources.Message;

@Slf4j
public class MessageListenerTask implements Runnable {

    private MessageListener messageListener;
    private Queue<Message> queue;
    
    public MessageListenerTask(Queue<Message> queue, MessageListener messageListener) {
        this.queue = queue;
        this.messageListener = messageListener;
    }
    
    @Override
    public void run() {
        Message msg = null;
        do {
            msg = queue.poll();
            try {
                if(msg != null) {
                    messageListener.onMessage(msg);
                }
            } catch (Exception e) {
                log.error("Couldnt consume message", e);
            }
        } while (msg != null);
    }

}
