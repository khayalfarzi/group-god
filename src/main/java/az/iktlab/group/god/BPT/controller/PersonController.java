package az.iktlab.group.god.BPT.controller;

import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.service.PersonService;
import az.iktlab.group.god.BPT.service.impl.PersonServiceImpl;

import java.util.List;

public class PersonController {

    private final PersonService personService;

    public PersonController() {
        personService = new PersonServiceImpl();
    }

    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }
}
