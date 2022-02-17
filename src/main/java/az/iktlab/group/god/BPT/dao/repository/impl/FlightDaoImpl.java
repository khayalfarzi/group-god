package az.iktlab.group.god.BPT.dao.repository.impl;

import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.dao.repository.FlightRepository;
import az.iktlab.group.god.BPT.db.ConnPostgresSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FlightDaoImpl implements FlightRepository {
    @Override
    public List<Flight> getAllFlights() {
        List<Flight> list = new LinkedList<>();
        try (Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flight");
            list = getFlights(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Flight> getAllFlightsByLocalDate(Date date) {
        List<Flight> list = new LinkedList<>();
        try (Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from flight where" +
                    " local_date >= '" + date + "'");

            ResultSet resultSet = preparedStatement.executeQuery();
            list = getFlights(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Flight getFlightById(Integer id) {
        Flight flight;
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flight where flight_id = '" + id + "'");
            flight = getFlight(resultSet);
            return flight;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Flight> search(String destination, Date localDate, int numberOfPeople) {
        List<Flight> list = new LinkedList<>();
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from flight" +
                    " where destination = '" + destination + "' and seats-full_seats > '" + numberOfPeople + "' and local_date = '" + localDate + "'");
            list = getFlights(resultSet);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Flight> getFlightsByNameAndSurname(String name, String surname) {
        List<Flight> flights;
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(
                    " select flight.* from person \n " +
                            " inner join book on person.person_id = book.person_id\n " +
                            " inner join flight on flight.flight_id = book.flight_id\n " +
                            " where\n " +
                            "person_name = ? " +
                            " and person_surname = ? "
            );
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            ResultSet resultSet = preparedStatement.executeQuery();
            flights = getFlights(resultSet);

            return flights;


        }catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Flight> getFlights(ResultSet resultSet) throws SQLException {
        List<Flight> list = new LinkedList<>();
        while (resultSet.next()){
            Integer flightId = resultSet.getInt("flight_id");
            Date localDate = resultSet.getDate("local_date");
            Time localTime = resultSet.getTime("local_time");
            String destination = resultSet.getString("destination");
            Integer seats = resultSet.getInt("seats");
            Integer fullSeats = resultSet.getInt("full_seats");

            Flight flight = new Flight(flightId, localDate, localTime, destination, seats, fullSeats);
            list.add(flight);
        }
        return list;
    }

    private Flight getFlight(ResultSet resultSet) throws SQLException {
        Flight flight = null;
        while (resultSet.next()){
            Integer flightId = resultSet.getInt("flight_id");
            Date localDate = resultSet.getDate("local_date");
            Time localTime = resultSet.getTime("local_time");
            String destination = resultSet.getString("destination");
            Integer seats = resultSet.getInt("seats");
            Integer fullSeats = resultSet.getInt("full_seats");

            flight = new Flight(flightId, localDate, localTime, destination, seats, fullSeats);
        }
        return flight;
    }
}
