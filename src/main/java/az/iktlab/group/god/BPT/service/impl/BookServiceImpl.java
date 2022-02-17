package az.iktlab.group.god.BPT.service.impl;

import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.dao.repository.BookRepository;
import az.iktlab.group.god.BPT.dao.repository.impl.BookDaoImpl;
import az.iktlab.group.god.BPT.service.BookService;
import az.iktlab.group.god.BPT.service.FlightService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private  BookRepository bookDao;
    private FlightService flightService;
    public BookServiceImpl(){
        bookDao = new BookDaoImpl();
        flightService = new FlightServiceImpl();
    }
    @Override
    public int book(Person person, int flightId) {
        return  bookDao.book(person,flightId);
    }

    @Override
    public List<Flight> myFlights(String name, String surname) {
        return flightService.flights(name,surname);
    }

    @Override
    public boolean cancel(int bookId) {
        if(bookDao.cancel(bookId)==1){
            return true;
        }
        else{
            return false;
        }
    }
}

