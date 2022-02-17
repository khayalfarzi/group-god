package az.iktlab.group.god.BPT.dao.repository;
import az.iktlab.group.god.BPT.dao.entity.Person;

import java.sql.ResultSet;

public interface BookRepository {
    int book(Person person, int flightId);
    int cancel(int bookId);
    ResultSet getBookById(int bookId);
}
