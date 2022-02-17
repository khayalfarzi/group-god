package az.iktlab.group.god.BPT.dao.repository.impl;

import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.dao.repository.BookRepository;
import az.iktlab.group.god.BPT.db.ConnPostgresSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookDaoImpl implements BookRepository {

    @Override
    public int book(Person person, int flightId) {
        int bookId=0;
        ResultSet rs;
        try( Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()) {
            String insertPerson="insert into person(person_name, person_surname)" +
                    " values('"+person.getPersonName()+"','"+person.getPersonSurname()+"') returning person_id";
            String addFullSeats = "update flight\n" +
                    "set full_seats = full_seats+1 where flight_id='"+flightId+"'";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(insertPerson);
            rs.next();
            int personId = rs.getInt("person_id");
            statement.executeUpdate(addFullSeats);
            String insertBook= "insert into book(person_id,flight_id) " +
                    "values('"+personId+"','"+flightId+"') returning book_id";
            rs = statement.executeQuery(insertBook);
            rs.next();
            bookId=rs.getInt("book_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookId;
    }

    @Override
    public int cancel(int bookId) {
        int response =0;
        ResultSet rs;
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            String deleteBook= "delete from book where book_id='"+bookId+"' returning person_id, flight_id";
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(deleteBook);
            rs.next();
            int deletedId = rs.getInt("person_id");
            int flightId= rs.getInt("flight_id");
            String deletePerson = "delete from person where person_id='"+deletedId+"'";
            statement.executeUpdate(deletePerson);
            String fullSeats = "Update flight set full_seats = full_seats-1 where flight_id ='"+flightId+"'";
            response = statement.executeUpdate(fullSeats);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return response;
    }
    @Override
    public ResultSet getBookById(int bookId){
        ResultSet rs=null;
        try(Connection connection = ConnPostgresSQL.getInstance("bpt").getConnection()){
            String selectQuery = "select * from book where book_id ='"+bookId+"'";
            Statement statement = connection.createStatement();
            rs= statement.executeQuery(selectQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
