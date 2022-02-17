package az.iktlab.group.god.BPT.service;

import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.dao.entity.Person;

import java.util.List;

public interface BookService {
    int book(Person person, int flightId);
    List<Flight> myFlights(String name, String surname);
    boolean cancel(int bookId);
}
