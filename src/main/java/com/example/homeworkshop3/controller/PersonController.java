package com.example.homeworkshop3.controller;

import com.example.homeworkshop3.dto.PersonCreationDto;
import com.example.homeworkshop3.dto.PersonDto;
import com.example.homeworkshop3.model.Person;
import com.example.homeworkshop3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Set;

@RestController
@Validated
@RequestMapping("api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public PersonDto createPerson(@Valid @RequestBody PersonCreationDto personCreationDTO) {
        return personService.createPerson(personCreationDTO);
    }

    @GetMapping
    public Set<Person> getPersons() {
        return personService.getPersons();
    }

    @GetMapping("/{id}")
    public PersonDto getPersonById(@PathVariable("id") Integer id) {
        return personService.getPersonById(id);
    }

    @PutMapping(value = "/{id}")
    public PersonDto updatePerson(@PathVariable("id") Integer id,
                                  @Valid @RequestBody PersonCreationDto personCreationDTO) {
        return personService.updatePersonById(id, personCreationDTO);
    }

    @DeleteMapping(value = "{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        personService.deletePersonById(id);
    }
}
