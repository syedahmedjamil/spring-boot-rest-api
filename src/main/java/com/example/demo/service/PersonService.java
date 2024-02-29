package com.example.demo.service;

import com.example.demo.doa.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("InMemoryPersonDatabase") PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAll() {
        return personDao.getAll();
    }

    public int add(Person person) {
        return personDao.add(person);
    }

    public int remove(UUID id) {
        return personDao.remove(id);
    }

    public int update(UUID id, Person person) {
        return personDao.update(id, person);
    }
}
