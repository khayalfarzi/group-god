package az.iktlab.group.god.BPT.dao.repository;

import az.iktlab.group.god.BPT.dao.entity.Person;

import java.sql.ResultSet;
import java.util.List;

public interface PersonRepository{

        List<Person> getAllPerson();
        ResultSet getPersonByFullName(String name, String surname);
}
