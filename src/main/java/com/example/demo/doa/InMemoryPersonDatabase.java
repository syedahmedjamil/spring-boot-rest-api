package com.example.demo.doa;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository("InMemoryPersonDatabase")
public class InMemoryPersonDatabase implements PersonDao {
    private final List<Person> personList = new ArrayList<>();

    @Override
    public List<Person> getAll() {
        return personList;
    }

    @Override
    public int add(Person person) {
        personList.add(person);
        System.out.println(personList.size());
        return personList.size();
    }

    @Override
    public int remove(UUID id) {
        var isRemoved = personList.removeIf(person -> person.id().equals(id));
        if (isRemoved) {
            return personList.size();
        }
        return -1;
    }

    @Override
    public int update(UUID id, Person person) {
        AtomicInteger returnValue = new AtomicInteger(-1);
        personList.stream()
                .filter(value -> value.id().equals(id))
                .findFirst()
                .ifPresent(value -> {
                    personList.set(personList.indexOf(value), new Person(id, person.name()));
                    returnValue.set(personList.size());
                });
        return returnValue.get();
    }
}
