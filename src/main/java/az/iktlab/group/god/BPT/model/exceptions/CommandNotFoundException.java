package az.iktlab.group.god.BPT.model.exceptions;

public class CommandNotFoundException extends Exception{

    @Override
    public String getMessage() {
        return " ____________________________________\n"
                .concat("|Command not found, Please try again!|")
                .concat("\n|____________________________________|");
    }
}
