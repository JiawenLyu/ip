import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static final int MAX_SIZE = 100;
    public static final String STRAIGHT_LINE = "-------------------------------------------";

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

    //echo the message
    public static void echoMessage(Task message, int index) {
        printHorizontalLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(message.toString());
        System.out.println("Now you have " + (index + 1) + " tasks in the list");
        printHorizontalLine();
    }

    //echo the list
    public static void echoList(ArrayList<Task> tasks) {
        printHorizontalLine();
        int index = 0;
        for (Task task : tasks) {
            System.out.println((index + 1) + ". " + task.toString());
            index++;
        }

        System.out.println();
        printHorizontalLine();
    }

    //change the status of the task
    public static void changeStatus(Task task) {
        printHorizontalLine();
        System.out.println("Nice! I've marked this task as done:");

        task.setIsDone(true);
        System.out.println(task.toString());

        System.out.println();
        printHorizontalLine();
    }

    public static Task createType(String message) {
        String[] infoEntered = message.split(" ");
        int nameLength;
        try {
            switch (infoEntered[0]) {
            case ("todo"):
                nameLength = 4;
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                return new ToDo(message.substring(nameLength + 1));
            case ("deadline"):
                nameLength = 8;
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                int indexBy = message.indexOf("/");
                return new Deadline(message.substring(nameLength + 1, indexBy - 1),
                        message.substring(indexBy + 4));
            case ("event"):
                nameLength = 5;
                if (infoEntered.length == 1) {
                    throw new DukeException();
                }
                int indexAt = message.indexOf("/");
                return new Event(message.substring(nameLength + 1, indexAt - 1),
                        message.substring(indexAt + 4));
            default:
                printHorizontalLine();
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                printHorizontalLine();
                return null;
            }
        } catch (DukeException e) {
            printHorizontalLine();
            System.out.println("☹ OOPS!!! The description cannot be empty.\n");
            printHorizontalLine();
            return null;
        }
    }

    public static void deleteItems(ArrayList<Task> tasks, int index) {
        printHorizontalLine();
        System.out.println("Noted. I've removed this task: ");
        System.out.println(tasks.get(index).toString());

        tasks.remove(tasks.get(index));

        System.out.println("Now you have " + tasks.size() + " items in the list.\n");
        printHorizontalLine();
    }

    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Scanner in = new Scanner(System.in);

        printWelcomeMessage();

        ArrayList<Task> tasks = new ArrayList<>();

        String enteredMessage = in.nextLine();
        int index = 0;
        while (!enteredMessage.equals("bye") && index < MAX_SIZE) {
            if (enteredMessage.equals("list")) {
                echoList(tasks);
            } else if (enteredMessage.startsWith("done")) {
                try {
                    int numberIndex = 5;
                    int itemIndex = Integer.parseInt(enteredMessage.substring(numberIndex)) - 1;
                    changeStatus(tasks.get(itemIndex));
                } catch (NumberFormatException e) {
                    printHorizontalLine();
                    System.out.println("☹ OOPS!!! The description cannot be empty.\n");
                    printHorizontalLine();
                }
            } else if (enteredMessage.startsWith("delete")) {
                int numberIndex = 7;
                int itemIndex = Integer.parseInt(enteredMessage.substring(numberIndex)) - 1;
                deleteItems(tasks, itemIndex);
                index--;
            } else {
                Task newTask = createType(enteredMessage);
                if (newTask != null) {
                    tasks.add(newTask);
                    echoMessage(newTask, index);
                    index++;
                }
            }
            enteredMessage = in.nextLine();
        }
        printByeMessage();
    }
}
