package com.example.demo.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
    private String latestMessage;

    @KafkaListener(topics = "LocalNews", groupId = "news-consumer-group")
    public void consume(String message)
    {
        this.latestMessage = message;
        System.out.println("message = " + message);
    }

    public String getLatestNews()
    {
        return latestMessage != null ? latestMessage : "No news yet";
    }


}
