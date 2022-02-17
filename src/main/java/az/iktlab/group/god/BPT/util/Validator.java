package az.iktlab.group.god.BPT.util;

import az.iktlab.group.god.BPT.model.constant.Command;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class Validator {
    public static BiPredicate<String, Command> whichOperation = (input,command) ->
            input.trim().equalsIgnoreCase(command.name()) ||
                    input.trim().equalsIgnoreCase(command.getShortName());

    public static boolean hasOperation(String input){
        return Arrays.stream(Command.values()).noneMatch(command -> whichOperation.test(input,command));
    }
}
