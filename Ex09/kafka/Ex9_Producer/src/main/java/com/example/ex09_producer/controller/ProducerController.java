package com.example.ex09_producer.controller;

import com.example.ex09_producer.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    public ProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/total-product/{id}")
    public ResponseEntity send(@PathVariable("id")  String id)
    {
        kafkaProducer.send(id);
        return ResponseEntity.ok("ok");
    }
}
