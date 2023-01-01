package com.joyful.java.kafka.consumer.repository;

import com.joyful.java.kafka.consumer.entity.LibraryEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryEventRepository extends MongoRepository<LibraryEventEntity, String> {
}
