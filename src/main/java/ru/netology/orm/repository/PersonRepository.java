package ru.netology.orm.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.orm.Person;


import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findByCity(String city) {
        String query = "SELECT p FROM Person p WHERE p.cityOfLiving = :city";
        return entityManager.createQuery(query, Person.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Person> findByAgeAbove(int age) {
        String query = "SELECT p FROM Person p WHERE p.id.age > :age ORDER BY p.id.age DESC";
        return entityManager.createQuery(query, Person.class)
                .setParameter("age", age)
                .getResultList();
    }

    public Person findByNameAndSurname(String name, String surname) {
        String query = "SELECT p FROM Person p WHERE p.id.name = :name AND p.id.surname = :surname";
        return entityManager.createQuery(query, Person.class)
                .setParameter("name", name)
                .setParameter("surname", surname)
                .getSingleResult();
    }

    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public void delete(Person person) {
        entityManager.remove(person);
    }
}
