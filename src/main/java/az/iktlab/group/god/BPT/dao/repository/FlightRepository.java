package az.iktlab.group.god.BPT.dao.repository;

import az.iktlab.group.god.BPT.dao.entity.Flight;

import java.sql.Date;
import java.util.List;

public interface FlightRepository {
    List<Flight> getAllFlights();
    List<Flight> getAllFlightsByLocalDate(Date date);
    Flight getFlightById(Integer id);
    List<Flight> search(String destination, Date localDate, int numberOfPeople) ;
    List<Flight> getFlightsByNameAndSurname(String name, String surname) ;
}
