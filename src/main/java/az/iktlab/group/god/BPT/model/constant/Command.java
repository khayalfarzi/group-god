package az.iktlab.group.god.BPT.model.constant;

public enum Command {
    SHOW("1"),
    INFO("2"),
    BOOK("3"),
    CANCEL("4"),
    FLIGHTS("5"),
    EXIT("6");

    private final String shortName;

    Command(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
