package duke.oop;

import java.util.Scanner;

public class Ui {
    public static final String STRAIGHT_LINE = "-------------------------------------------";
    private Parser parser;

    //print the horizontal line
    public static void printHorizontalLine() {
        System.out.println(STRAIGHT_LINE);
    }

    //print a welcome message
    public static void printWelcomeMessage() {
        printHorizontalLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        printHorizontalLine();
    }

    //print a goodbye message
    public static void printByeMessage() {
        printHorizontalLine();
        System.out.println("Bye. Hope to see you again soon!\n");
        printHorizontalLine();
    }

    //deal with the input
    public void dealWithInput(TaskList tasks){
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
                default:
                    break;
                }
            }
        }
    }
}
