package com.example.demo.producers;

import com.example.demo.businessLogic.SuperInterestingEventGenerator;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "LocalNews";
    private volatile boolean schedulerEnabled = false;

    public EventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @Scheduled(fixedRate = 1000)
    public void sendContinuous() {
        if (schedulerEnabled) {
            kafkaTemplate.send(TOPIC, SuperInterestingEventGenerator.getEvent());
        }
    }

    public void setSchedulerEnabled(boolean enableState) {
        this.schedulerEnabled = enableState;
    }

    public boolean isSchedulerEnabled() {
        return schedulerEnabled;
    }
}
