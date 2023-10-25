package com.example.command_Service.config_kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableKafka
public class EventHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    private final KafkaTemplate<String,String> kafkaTemplate;
    private String topicName ="substances";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public EventHandler(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public boolean publishEvent(Event event){
        try{
            String payload = objectMapper.writeValueAsString(event);
            kafkaTemplate.send(topicName,""+payload);
            return true;
        }catch(Exception e){
            LOGGER.error("error:",e);
            return false;
        }

    }

}