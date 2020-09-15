import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Duke {

    public static final int MAX_SIZE = 100;
    static Task[] tasks = new Task[MAX_SIZE];
    public static final String STRAIGHT_LINE = "-------------------------------------------";
    public static final String FILE_PATH = "duke.txt";
    static int taskIndex = 0;

    //write to the file
    public static void saveToFile(String FILE_PATH){
        try{
            File f = new File(FILE_PATH);
            FileWriter fw = new FileWriter(FILE_PATH);
            for (int i = 0; i < taskIndex; i++){
                fw.write(tasks[i].saveToFile());
            }
            fw.close();
        } catch (IOException e){
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    //load from file
    public static void loadFromFile(String FILE_PATH){
        try{
            File f = new File(FILE_PATH);
            Scanner s = new Scanner(f);
            Task task;
            while(s.hasNext()){
                String[] readTask = s.nextLine().split(" | ");
                switch (readTask[0]) {
                case ("T"):
                    task = new ToDo(readTask[2]);
                    break;
                case ("D"):
                    task = new Deadline(readTask[2], readTask[3]);
                    break;
                case ("E"):
                    task = new Event(readTask[2], readTask[3]);
                    break;
                default:
                    task = new Task(readTask[2]);
                }

                if (readTask[1].equals("true")){
                    task.setIsDone(true);
                }
                tasks[taskIndex] = task;
                taskIndex++;
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

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
    public static void echoList(Task[] tasks) {
        printHorizontalLine();
        int index = 0;
        while (tasks[index] != null) {
            System.out.println((index + 1) + ". " + tasks[index].toString());
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
                if (message.equals("todo")) {
                    throw new DukeException();
                }
                return new ToDo(message.substring(nameLength + 1));
            case ("deadline"):
                nameLength = 8;
                if (message.equals("deadline")) {
                    throw new DukeException();
                }
                int indexBy = message.indexOf("/");
                return new Deadline(message.substring(nameLength + 1, indexBy - 1),
                        message.substring(indexBy + 4));
            case ("event"):
                nameLength = 5;
                if (message.equals("event")) {
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
        } catch (DukeException e){
            printHorizontalLine();
            System.out.println("☹ OOPS!!! The description cannot be empty.\n");
            printHorizontalLine();
            return null;
        }
    }

    public static void main(String[] args) {
        
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        loadFromFile(FILE_PATH);
        
        Scanner in = new Scanner(System.in);       
        
        printWelcomeMessage();
        String enteredMessage = in.nextLine();

            while (!enteredMessage.equals("bye") && taskIndex < MAX_SIZE) {
                if (enteredMessage.equals("list")) {
                    echoList(tasks);
                } else if (enteredMessage.startsWith("done")) {
                    try {
                        int numberIndex = 5;
                        int itemIndex = Integer.parseInt(enteredMessage.substring(numberIndex)) - 1;
                        changeStatus(tasks[itemIndex]);
                    } catch (NumberFormatException e) {
                        printHorizontalLine();
                        System.out.println("☹ OOPS!!! The description cannot be empty.\n");
                        printHorizontalLine();
                    }
                    saveToFile(FILE_PATH);
                } else {
                    tasks[taskIndex] = createType(enteredMessage);
                    if (tasks[taskIndex] != null) {
                        echoMessage(tasks[taskIndex], taskIndex);
                        taskIndex++;
                    }
                    saveToFile(FILE_PATH);
                }
                enteredMessage = in.nextLine();
            }

        printByeMessage();
    }
}
