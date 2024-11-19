package ru.netology.orm.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.orm.Person;
import ru.netology.orm.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCity(city);
    }

    @GetMapping("/age-above")
    public List<Person> getPersonsByAgeAbove(@RequestParam int age) {
        return personRepository.findByAgeAbove(age);
    }

    @GetMapping("/by-name-and-surname")
    public Person getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}
