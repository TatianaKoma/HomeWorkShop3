package com.example.homeworkshop3.collection;

import com.example.homeworkshop3.model.Person;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PersonCollection {
    public Set<Person> persons = new HashSet<>();
}
