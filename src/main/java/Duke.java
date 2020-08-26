import java.util.Scanner;

public class Duke {
    
    //print the horizontal line
    public static void printHorizontalLine() {
        String STRAIGHT_LINE = "-------------------------------------------";
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
    public static void echoMessage(String message) {
        printHorizontalLine();
        System.out.println("added: " + message + "\n");
        printHorizontalLine();
    }
    
    //echo the list
    public static void echoList(Task[] tasks) {
        printHorizontalLine();
        int index = 0;
        while (tasks[index] != null){
            if (tasks[index].description.equals("list")) {
                break;
            }

            System.out.println((index + 1) +". [" + tasks[index].getStatusIcon() + "] "
                    + tasks[index].description);
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
        System.out.println(" [" + task.getStatusIcon() + "] " + task.description);

        System.out.println();
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
        
        Task[] tasks = new Task[100];
        int index = 0;

        tasks[index] = new Task(in.nextLine());
        while (tasks[index] != null && !tasks[index].description.equals("bye")) {
            if (tasks[index].description.equals("list")) {
                echoList(tasks);
                index--;
            } else if (tasks[index].description.startsWith("done")) {
                int itemIndex = Integer.parseInt(tasks[index].description.substring(5)) - 1;
                changeStatus(tasks[itemIndex]);
                index--;
            } else {
                echoMessage(tasks[index].description);
            }

            index++;
            tasks[index] = new Task(in.nextLine());
        }

        printByeMessage();
    }
}
