package com.learnwithaniket.kafka.springboot.kafkaspringbootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithaniket.kafka.springboot.kafkaspringbootexample.consumer.MyFirstTopicConsumer;

@RestController
@RequestMapping("/kafka/messages")
public class KafkaMessageController {

    private KafkaTemplate<String, String> template;
    private MyFirstTopicConsumer myFirstTopicConsumer;

    @Value("${kafka.topic}")
    private String topic;

    public KafkaMessageController(KafkaTemplate<String, String> template, MyFirstTopicConsumer myFirstTopicConsumer) {
        this.template = template;
        this.myFirstTopicConsumer = myFirstTopicConsumer;
    }

    @PostMapping(consumes = MediaType.TEXT_HTML_VALUE)
    public void produce(@RequestBody String message) {
        template.send(topic, message);
    }

    @GetMapping
    public @ResponseBody List<String> getMessages() {
        return myFirstTopicConsumer.getMessages();
    }
}
