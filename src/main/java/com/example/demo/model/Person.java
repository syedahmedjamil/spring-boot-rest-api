package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record Person(UUID id, @NotBlank @JsonProperty("name") String name) {

    public Person {
        if (id == null)
            id = UUID.randomUUID();
    }
}
//public class Person {
//    private final UUID id;
//    @NotBlank
//    private final String name;
//
//    public Person(@JsonProperty UUID id, @JsonProperty String name) {
//        if (id == null) {
//            id = UUID.randomUUID();
//        }
//        this.id = id;
//        this.name = name;
//    }
//
//
//
//    public UUID getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//}
