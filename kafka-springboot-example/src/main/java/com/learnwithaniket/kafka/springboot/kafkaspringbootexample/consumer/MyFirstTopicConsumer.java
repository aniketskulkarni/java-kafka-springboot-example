package com.learnwithaniket.kafka.springboot.kafkaspringbootexample.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MyFirstTopicConsumer {

    private final List<String> messages = new ArrayList<>();

    @KafkaListener(topics = "myFirstTopic", groupId = "kafka-groupId")
    public void listen(String message) {
        synchronized (messages) {
            messages.add(message);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}
