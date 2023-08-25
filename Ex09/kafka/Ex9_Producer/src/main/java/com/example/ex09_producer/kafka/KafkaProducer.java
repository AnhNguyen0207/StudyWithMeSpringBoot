package com.example.ex09_producer.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class KafkaProducer {
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, Object> kafkaTemplateObj;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate,KafkaTemplate<String,Object> kafkaTemplateObj) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplateObj = kafkaTemplateObj;
    }

    public void send(String msg)
    {
        kafkaTemplate.send("ex100",msg);
    }
}
