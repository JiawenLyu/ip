package duke.oop;

import java.util.Scanner;

public class Ui {
    public static final String STRAIGHT_LINE = "-------------------------------------------";
    private Parser parser;


    public static void printHorizontalLine() {
        System.out.println(STRAIGHT_LINE);
    }

    /**
     * Welcome users when the program starts.
     */
    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        printHorizontalLine();
    }

    /**
     * Say goodbye to users before exits when the program ends.
     */
    public static void printByeMessage() {
        printHorizontalLine();
        System.out.println("Bye. Hope to see you again soon!\n");
        printHorizontalLine();
    }

    /**
     * Get user inputs and deal with the commands.
     * Update the information about tasks on task list and the file once the information of tasks changes.
     *
     * @param tasks taskList contains all the information about current tasks.
     */
    public void dealWithInput(TaskList tasks) {
        Scanner in = new Scanner(System.in);
        String enteredMessage;
        while (in.hasNextLine()) {
            enteredMessage = in.nextLine();
            String head = parser.getBehavior(enteredMessage);
            if (head != null) {
                switch (head) {
                case "list":
                    tasks.echoList();
                    break;
                case "done":
                    tasks.done(enteredMessage);
                    break;
                case "todo":
                    tasks.addTodo(enteredMessage);
                    Storage.saveToFile(tasks);
                    break;
                case "event":
                    tasks.addEvent(enteredMessage);
                    Storage.saveToFile(tasks);
                    break;
                case "deadline":
                    tasks.addDeadline(enteredMessage);
                    Storage.saveToFile(tasks);
                    break;
                case "delete":
                    tasks.delete(enteredMessage);
                    Storage.saveToFile(tasks);
                    break;
                case "bye":
                    Ui.printByeMessage();
                    return;
                case "find":
                    tasks.findTasks(enteredMessage);
                    break;
                default:
                    break;
                }
            }
        }
    }
}
