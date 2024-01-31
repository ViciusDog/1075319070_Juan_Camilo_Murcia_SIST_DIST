package com.project.project.service.services;

import com.project.project.model.Person;
import com.project.project.service.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void addUpdate(Person person) {
        System.out.println(personRepository.save(person).toString());
    }

    public Person findById(Integer id) {
        Optional<Person> user = personRepository.findById(id);
        return user.orElse(new Person());
    }

    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }
}
