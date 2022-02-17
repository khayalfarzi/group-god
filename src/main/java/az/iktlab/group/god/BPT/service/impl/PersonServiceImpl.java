package az.iktlab.group.god.BPT.service.impl;

import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.dao.repository.PersonRepository;
import az.iktlab.group.god.BPT.dao.repository.impl.PersonDaoImpl;
import az.iktlab.group.god.BPT.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl() {
        personRepository = new PersonDaoImpl();
    }

    @Override
    public List<Person> getAllPerson() {
        //business logic
        return personRepository.getAllPerson();
    }
}
