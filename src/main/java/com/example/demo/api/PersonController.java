package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    //returns all persons stored in database
    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    //add a person to database and returns number of total persons
    @PostMapping
    public int add(@Valid @NotNull @RequestBody Person person) {
        return personService.add(person);
    }

    @DeleteMapping(path = "{id}")
    public int remove(@PathVariable("id") UUID id) {
        return personService.remove(id);
    }

    @PutMapping(path = "{id}")
    public int update(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person) {
        return personService.update(id, person);
    }

}
