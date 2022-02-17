package az.iktlab.group.god.BPT.dao.repository.impl;

import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.dao.repository.BookRepository;
import az.iktlab.group.god.BPT.dao.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;


class BookDaoImplTest {
    private  final Person person;
    private final  BookRepository bookDao;
    private final  PersonRepository personDao;
    private ResultSet rs;
    private final  int flightId;
    public BookDaoImplTest(){
        person = new Person();
        person.setPersonName("Test-name");
        person.setPersonSurname("Test-surname");
        bookDao = new BookDaoImpl();
        personDao = new PersonDaoImpl();
        flightId = 1;
    }
    @Test
    void book() throws SQLException {

        int bookId = bookDao.book(person,flightId);
        rs = bookDao.getBookById(bookId);
        rs.next();
        Assertions.assertEquals(rs.getInt("flight_id"),flightId);
        ResultSet rs2 = personDao.getPersonByFullName(person.getPersonName(),person.getPersonSurname());
        rs2.next();
        Assertions.assertEquals(rs2.getInt("person_id"),rs.getInt("person_id"));
        bookDao.cancel(bookId);
    }

    @Test
    void cancel() throws SQLException {
        int bookId = bookDao.book(person,flightId);
        int result = bookDao.cancel(bookId);
        Assertions.assertEquals(result,1);
        rs = bookDao.getBookById(bookId);
        Assertions.assertTrue(!rs.next());
        rs = personDao.getPersonByFullName(person.getPersonName(),person.getPersonSurname());
        Assertions.assertTrue(!rs.next());
    }
}