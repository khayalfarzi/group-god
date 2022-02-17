package az.iktlab.group.god.BPT.dao.repository.impl;

import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.dao.repository.PersonRepository;
import az.iktlab.group.god.BPT.db.ConnPostgresSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonDaoImpl implements PersonRepository {

    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public ResultSet getPersonByFullName(String name, String surname) {
        ResultSet rs = null;
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()) {
            String selectQuery = "Select * from person where person_name = '"+name+"' and person_surname = " +
                    "'"+surname+"'";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
