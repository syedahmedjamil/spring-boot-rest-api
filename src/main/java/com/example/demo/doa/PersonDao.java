package com.example.demo.doa;

import com.example.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    List<Person> getAll();

    int add(Person person);

    int remove(UUID id);

    int update (UUID id, Person person);
}
