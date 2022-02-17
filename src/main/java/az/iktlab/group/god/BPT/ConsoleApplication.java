package az.iktlab.group.god.BPT;

import az.iktlab.group.god.BPT.controller.PersonController;
import az.iktlab.group.god.BPT.model.constant.Command;
import az.iktlab.group.god.BPT.model.exceptions.CommandNotFoundException;
import az.iktlab.group.god.BPT.util.Validator;

import java.util.Scanner;

public class ConsoleApplication {

    private final Scanner scanner;
    private final PersonController personController;

    public ConsoleApplication(){
        personController = new PersonController();
        scanner = new Scanner(System.in);
    }
    public static void run() throws InterruptedException {
        ConsoleApplication console = new ConsoleApplication();
        while (true) {
            String sb = String.format("%s%n", " ___________________________________")
                    .concat(String.format("|%-35s|%n", "1. Online board (SHOW)"))
                    .concat(String.format("|%-35s|%n", "2. Show the flight info (INFO)"))
                    .concat(String.format("|%-35s|%n", "3. Search and book a flight (BOOK)"))
                    .concat(String.format("|%-35s|%n", "4. Cancel the booking (CANCEL)"))
                    .concat(String.format("|%-35s|%n", "5. My flights (FLIGHTS)"))
                    .concat(String.format("|%-35s|%n", "6. Exit (EXIT)"))
                    .concat(String.format("|%-35s|%n", "___________________________________"));
            System.out.println(sb);

            System.out.print("Enter command : ");
            String input = console.scanner.nextLine();

            checkHasCommand(input);

            if(checkWhichCommand(input,Command.SHOW)){
                //example
                console.personController.getAllPerson();
                //flightController.show
                Thread.sleep(2000);
            }
            else if(checkWhichCommand(input,Command.INFO)){
                //flightController.info();
                Thread.sleep(2000);
            }
            else if(checkWhichCommand(input,Command.BOOK)){
                //bookController.book();
                Thread.sleep(2000);
            }
            else if(checkWhichCommand(input,Command.CANCEL)){
                //bookController.cancel();
                Thread.sleep(2000);
            }
            else if(checkWhichCommand(input,Command.FLIGHTS)){
                //bookController.flights();
                Thread.sleep(2000);
            }
            else if(checkWhichCommand(input,Command.EXIT)){
                break;
            }

        }
    }
    private static void checkHasCommand(String input) throws InterruptedException {
        if (Validator.hasOperation(input)) {
            try {
                throw new CommandNotFoundException();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }finally {
                Thread.sleep(2000);
            }
        }
    }

    private static boolean checkWhichCommand(String input,Command command){
        return Validator.whichOperation.test(input, command);
    }
}
