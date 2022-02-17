package az.iktlab.group.god.BPT.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Flight {
    private Integer flightId;
    private Date date;
    private Time time;
    private String destination;
    private int seats;
    private int fullSeats;
    private List<Book> bookList;

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Flight(Integer flightId, Date date, Time time, String destination, Integer seats, Integer fullSeats) {
        this.flightId = flightId;
        this.date = date;
        this.time = time;
        this.destination = destination;
        this.seats = seats;
        this.fullSeats = fullSeats;
    }

    @Override
    public String toString() {
        return String.format("Flight - %d :\nlocalDate=%s, localTime=%s, destination=%s, emptySeats=%s",
                getFlightId(), this.getDate(), this.getTime(), getDestination(), getSeats() - getFullSeats());
    }
}
