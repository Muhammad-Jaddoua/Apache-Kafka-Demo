package com.example.demo.producers;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.stereotype.Service;

import java.util.Properties;

import static org.springframework.core.io.support.PropertiesLoaderUtils.loadProperties;

@Service
public class EventProducer {
    Properties config = loadProperties("kafka.properties");


    private final KafkaProducer<String, String> producer = new KafkaProducer<>();

}
