package com.joyful.java.kafka.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joyful.java.kafka.consumer.entity.Book;
import com.joyful.java.kafka.consumer.entity.LibraryEventEntity;
import com.joyful.java.kafka.consumer.entity.LibraryEventType;
import com.joyful.java.kafka.consumer.repository.LibraryEventRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LibraryEventConsumerService {

    @Autowired
    LibraryEventRepository libraryEventRepository;

    @Autowired
    ObjectMapper objectMapper;

    @KafkaListener(topics = {"library-events"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {

        try {
            LibraryEventEntity entity = objectMapper.readValue(consumerRecord.value(), LibraryEventEntity.class);
            libraryEventRepository.save(entity);
            log.info("Library event has been persisted successfully " + entity);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e){
            log.error("Object Mapping error " + e.getMessage());
        }


    }

}
