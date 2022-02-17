package az.iktlab.group.god.BPT.controller;

import az.iktlab.group.god.BPT.ConsoleApplication;
import az.iktlab.group.god.BPT.dao.entity.Flight;
import az.iktlab.group.god.BPT.dao.entity.Person;
import az.iktlab.group.god.BPT.service.BookService;
import az.iktlab.group.god.BPT.service.FlightService;
import az.iktlab.group.god.BPT.service.impl.BookServiceImpl;
import az.iktlab.group.god.BPT.service.impl.FlightServiceImpl;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class BookController {
    private final Scanner scan;
    private final FlightController flightController;
    private final FlightService flightService;
    private final BookService bookService;
    public BookController() {
        scan = new Scanner(System.in);
        flightController = new FlightController();
        bookService = new BookServiceImpl();
        flightService= new FlightServiceImpl();

    }
    public void book() throws InterruptedException {
        List<Flight> flights = flightController.search();
        if(!flights.isEmpty()){
            System.out.println("__________________________________________________" +
                    "________________________________________________________");
            for (Flight f:flights)
            {
                System.out.println(f);
                System.out.println("__________________________________________________" +
                        "________________________________________________________");
            }
            System.out.println("select a flight id or return main menu (0)");
            int selectedId = scan.nextInt();
            if(selectedId==0){
                ConsoleApplication.run();
            }
            else {
                System.out.print("Please enter number of people: ");
                int numberPeople = scan.nextInt();
                Person person = new Person();
                Person[] persons = new Person[numberPeople];
                int[] booksId = new int[persons.length];
                for (int i=0;i< persons.length;i++){
                    System.out.printf("%d.passenger \nfull name (name surname): ",i+1);
                    person.setPersonName(scan.next());
                    person.setPersonSurname(scan.next());
                    persons[i]=person;
                }
                for (int i =0; i<persons.length;i++) {
                    booksId[i]= bookService.book(persons[i],selectedId);
                }
                System.out.printf("your booking id: %s \n", Arrays.toString(booksId));
            }
        }else
        {
            System.out.println("No result");
            System.out.println("try again(1) or return main menu(any key)");
            String selected = scan.next();
            if(selected.equals("1")){
                book();
            }
            else {
                ConsoleApplication.run();
            }
        }

    }

    public void cancel(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your booking Id: ");
        int bookId = scan.nextInt();
        System.out.println( bookService.cancel(bookId));
    }

    public void myFlights() throws InterruptedException {
        System.out.print("Enter full name (name surname): ");
        String name = (scan.next());
        String surname = (scan.next());
        List<Flight> myFlights = bookService.myFlights(name,surname);
        if(!myFlights.isEmpty()) {
            System.out.println("__________________________________________________" +
                    "________________________________________________________");
            for (Flight f : myFlights) {
                System.out.println(f);
                System.out.println("__________________________________________________" +
                        "________________________________________________________");
            }
        } else
        {
            System.out.println("No result");
            System.out.println("try again(1) or return main menu(any key)");
            String selectedKey = scan.next();
            if(selectedKey.equals("1")){
                myFlights();
            }
            else {
                ConsoleApplication.run();
            }
        }
    }
}
