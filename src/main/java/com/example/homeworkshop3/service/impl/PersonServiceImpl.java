package com.example.homeworkshop3.service.impl;

import com.example.homeworkshop3.collection.CartCollection;
import com.example.homeworkshop3.collection.PersonCollection;
import com.example.homeworkshop3.dto.PersonCreationDto;
import com.example.homeworkshop3.dto.PersonDto;
import com.example.homeworkshop3.exception.NotFoundException;
import com.example.homeworkshop3.mapper.PersonMapper;
import com.example.homeworkshop3.model.Person;
import com.example.homeworkshop3.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final String PERSON_NOT_FOUND = "Person with id %s was not found";

    private final PersonMapper mapper;
    private final PersonCollection personCollection;
    private final CartCollection cartCollection;

    @Override
    public PersonDto createPerson(PersonCreationDto personCreationDTO) {
        Person newPerson = mapper.toPerson(personCreationDTO);
        if (personCollection.persons.isEmpty()) {
            newPerson.setId(1);
        } else {
            Integer id = personCollection.persons.size() + 1;
            newPerson.setId(id);
        }
        newPerson.setCarts(cartCollection.carts);
        personCollection.persons.add(newPerson);
        return mapper.toPersonDTO(newPerson);
    }

    @Override
    public PersonDto getPersonById(Integer id) {
        Person person = personCollection.persons.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PERSON_NOT_FOUND, id)));
        return mapper.toPersonDTO(person);
    }

    @Override
    public Set<Person> getPersons() {
        return new HashSet<>(personCollection.persons);
    }

    @Override
    public PersonDto updatePersonById(Integer id, PersonCreationDto personCreationDTO) {
        Person personForUpdate = personCollection.persons.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PERSON_NOT_FOUND, id)));
        personForUpdate.setName(personCreationDTO.getName());
        personForUpdate.setSurname(personCreationDTO.getSurname());
        personForUpdate.setEmail(personForUpdate.getEmail());
        personCollection.persons.add(personForUpdate);
        return mapper.toPersonDTO(personForUpdate);
    }

    @Override
    public void deletePersonById(Integer id) {
        Person personForDelete = personCollection.persons.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format(PERSON_NOT_FOUND, id)));
        personCollection.persons.remove(personForDelete);
    }
}
