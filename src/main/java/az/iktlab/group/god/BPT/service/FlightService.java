package az.iktlab.group.god.BPT.service;

import az.iktlab.group.god.BPT.dao.entity.Flight;

import java.sql.Date;
import java.util.List;

public interface FlightService {

    List<Flight> show();
    Flight info(Integer flightId);
    List<Flight> search(String destination, Date localDate, int numberOfPeople);
    List<Flight> flights(String name, String surname);
}
