package az.iktlab.group.god.BPT.controller;

import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.service.FlightService;
import az.iktlab.group.god.BPT.service.impl.FlightServiceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class FlightController {

    private static final Scanner scanner=new Scanner(System.in);
    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService=flightService;
    }

    public FlightController(){
        this.flightService=new FlightServiceImpl();
    }

    public List<Flight> show(){
        List<Flight> flights = flightService.show();
        System.out.println(flights.isEmpty() ? "There are no flights for the next 24 hours" : flights);
        return flights;
    }

    public Flight info(){
        System.out.println("Please flight ID: ");
        int flight_id =scanner.nextInt();

        Flight flight=flightService.info(flight_id);
        System.out.println(flight.getFlightId() != null ? flight :
                "No flight matching flight number was found\nPlease check again");
        return flight;
    }

    public List<Flight> search(){
        System.out.println("Please enter destination< date and number of people; \ndestination: ");
        String destination =scanner.nextLine();
        System.out.println("date(YYY-MM-DD):");
        String date= scanner.nextLine();
        System.out.println("Number of people: ");
        int numberOfPeople = scanner.nextInt();

        return  flightService.search(destination, Date.valueOf(date), numberOfPeople);



    }
}
