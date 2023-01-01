package com.joyful.java.kafka.consumer.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "library-events")

@Data
@Builder
@NoArgsConstructor

public class LibraryEventEntity {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId libraryEventId;

    private Integer messageId;
    //    private Header header;
    private LibraryEventType libraryEventType;
    private Book book;


    @PersistenceCreator
    public LibraryEventEntity(ObjectId libraryEventId, Integer messageId, LibraryEventType libraryEventType, Book book) {
        this.libraryEventId = libraryEventId;
        this.messageId = messageId;
        this.libraryEventType = libraryEventType;
        this.book = book;
    }
}