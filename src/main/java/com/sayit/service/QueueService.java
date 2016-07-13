package com.sayit.service;

import java.io.IOException;

import com.sayit.resources.Message;

public interface QueueService {

    void publish(Message message) throws IOException;

}
