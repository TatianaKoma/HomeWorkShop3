package com.example.homeworkshop3.service;

import com.example.homeworkshop3.dto.PersonCreationDto;
import com.example.homeworkshop3.dto.PersonDto;
import com.example.homeworkshop3.model.Person;

import java.util.Set;

public interface PersonService {

    PersonDto createPerson(PersonCreationDto personCreationDTO);

    PersonDto getPersonById(Integer id);

    Set<Person> getPersons();

    PersonDto updatePersonById(Integer id, PersonCreationDto personCreationDTO);

    void deletePersonById(Integer id);
}
