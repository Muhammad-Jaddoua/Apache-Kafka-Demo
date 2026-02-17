package com.example.demo.controllers;

import com.example.demo.consumers.EventConsumer;
import com.example.demo.producers.EventProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    private final EventProducer eventProducer;
    private final EventConsumer eventConsumer;
    private static final String TOPIC = "LocalNews";

    public DemoController(EventProducer eventProducer, EventConsumer eventConsumer) {
        this.eventProducer = eventProducer;
        this.eventConsumer = eventConsumer;
    }


    @PostMapping("/publish/{message}")
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean publishEvent(@PathVariable String message){
        eventProducer.send(TOPIC ,message);
        return true;
    }

    @GetMapping("/latest-news")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> receiveEvent(){
        String latestNews = eventConsumer.getLatestNews();
        String html = "<html><body><h1>Latest Local News</h1><p> "+ latestNews +" </p></body></html>";
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(html);
    }

    @PostMapping("/scheduler/{enableState}")
    public String toggleScheduler(@PathVariable boolean enableState) {
        eventProducer.setSchedulerEnabled(enableState);
        return "Scheduler " + (enableState ? "enabled" : "disabled");
    }

    @GetMapping("/scheduler/status")
    public boolean getSchedulerStatus() {
        return eventProducer.isSchedulerEnabled();
    }

}
