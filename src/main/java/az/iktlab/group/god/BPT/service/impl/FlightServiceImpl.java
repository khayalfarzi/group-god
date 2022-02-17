package az.iktlab.group.god.BPT.service.impl;

import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.dao.repository.FlightRepository;
import az.iktlab.group.god.BPT.dao.repository.impl.FlightDaoImpl;
import az.iktlab.group.god.BPT.service.FlightService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(){
        flightRepository = new FlightDaoImpl();
    }

    @Override
    public List<Flight> show() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 =LocalDate.of(localDate.getYear(),localDate.getMonth(), localDate.getDayOfMonth() -1);
        Date date = Date.valueOf(localDate1);
        return  flightRepository.getAllFlightsByLocalDate(date);
    }

    @Override
    public Flight info(Integer flightId) {
        return flightRepository.getFlightById(flightId);
    }

    @Override
    public List<Flight> search(String destination, Date localDate, int numberOfPeople) {
        return flightRepository.search(destination, localDate, numberOfPeople);
    }

    @Override
    public List<Flight> flights(String name, String surname) {
        return flightRepository.getFlightsByNameAndSurname(name, surname);
    }
}
