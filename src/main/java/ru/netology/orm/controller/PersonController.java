package ru.netology.orm.controller;

import ru.netology.orm.Person;
import ru.netology.orm.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLivingIgnoreCase(city);
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(updatedPerson.getName());
                    person.setSurname(updatedPerson.getSurname());
                    person.setAge(updatedPerson.getAge());
                    person.setPhoneNumber(updatedPerson.getPhoneNumber());
                    person.setCityOfLiving(updatedPerson.getCityOfLiving());
                    return personRepository.save(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
