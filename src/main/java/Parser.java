
public class Parser {
    private static String command;
    private static final String BYE = "bye";
    private static final String LIST = "list";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String DELETE = "delete";
    private static final String DONE = "done";
    private static final String FIND = "find";

    public Parser(String command){
        this.command = command;
    }

    public static String getBehavior(String command) {
        String[] infoEntered = command.split(" ");
        try {
            if (command.equals(LIST)) {
                return LIST;
            } else if (command.equals(BYE)) {
                return BYE;
            } else if (command.startsWith(TODO)) {
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                return TODO;
            } else if (command.startsWith(DEADLINE)){
                if (infoEntered.length == 1 || !command.contains("/by")) {
                    throw new DukeException();
                }
                return DEADLINE;
            } else if (command.startsWith(EVENT)){
                if (infoEntered.length == 1 || !command.contains("/at")) {
                    throw new DukeException();
                }
                return EVENT;
            } else if (command.startsWith(DELETE)){
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                return DELETE;
            } else if (command.startsWith(DONE)){
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                return DONE;
            } else if (command.startsWith(FIND)){
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                return FIND;
            } else {
                Ui.printHorizontalLine();
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                Ui.printHorizontalLine();
                return null;
            }
        } catch (DukeException e){
            Ui.printHorizontalLine();
            System.out.println("OOPS!!! The description cannot be empty or invalid.\n");
            Ui.printHorizontalLine();
            return null;
        }
    }
}
