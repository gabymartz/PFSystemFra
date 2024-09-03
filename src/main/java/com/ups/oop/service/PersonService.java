package com.ups.oop.service;

import com.ups.oop.dto.PersonDTO;
import com.ups.oop.entity.Person;
import com.ups.oop.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ResponseEntity createPerson(PersonDTO personDTO) {
        String personId = personDTO.getId();
        Optional<Person> personOptional = personRepository.findByPersonId(personId);

        if (personOptional.isPresent()) {
            String errorMessage = "Person with id " + personId + " already exists";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        } else {
            if (personDTO.getName().contains(" ")) {
                String[] nameStrings = personDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];

                Person person = new Person(personId, name, lastname, personDTO.getAge());
                personRepository.save(person);
                return ResponseEntity.status(HttpStatus.OK).body(personDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person name must contain two strings separated by a whitespace");
            }
        }
    }

    public ResponseEntity getAllPeople() {
        Iterable<Person> personIterable = personRepository.findAll();
        List<PersonDTO> peopleList = new ArrayList<>();

        for (Person p : personIterable) {
            PersonDTO personDTO = new PersonDTO(
                    p.getPersonId(),
                    p.getName(),
                    p.getLastname(),
                    p.getAge()
            );
            peopleList.add(personDTO);
        }

        if (peopleList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No people found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(peopleList);
    }

    public ResponseEntity getPersonById(String personId) {
        Optional<Person> personOptional = personRepository.findByPersonId(personId);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            PersonDTO personDTO = new PersonDTO(
                    person.getPersonId(),
                    person.getName(),
                    person.getLastname(),
                    person.getAge()
            );
            return ResponseEntity.status(HttpStatus.OK).body(personDTO);
        } else {
            String errorMessage = "Person with id " + personId + " does not exist";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity updatePerson(PersonDTO personDTO) {
        String personId = personDTO.getId();
        Optional<Person> personOptional = personRepository.findByPersonId(personId);

        if (personOptional.isPresent()) {
            Person person = personOptional.get();

            if (personDTO.getName().contains(" ")) {
                String[] nameStrings = personDTO.getName().split(" ");
                String name = nameStrings[0];
                String lastname = nameStrings[1];

                person.setName(name);
                person.setLastname(lastname);
                person.setAge(personDTO.getAge());
                personRepository.save(person);
                return ResponseEntity.status(HttpStatus.OK).body(personDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person name must contain two strings separated by a whitespace");
            }
        } else {
            String errorMessage = "Person with id " + personId + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    public ResponseEntity deletePersonById(String personId) {
        Optional<Person> personOptional = personRepository.findByPersonId(personId);
        if (personOptional.isPresent()) {
            personRepository.delete(personOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Person with id " + personId + " removed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person with id " + personId + " not found");
        }
    }
}
