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
        while (tasks[index] != null){
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
        System.out.println(" [" + task.getStatusIcon() + "] " + task.description);

        System.out.println();
        printHorizontalLine();
    }

    public static Task createType(String message) {
        String[] infoEntered = message.split(" ");
        int nameLength;
        switch (infoEntered[0]) {
        case ("todo"):
            nameLength = 4;
            return new ToDo(message.substring(nameLength + 1));
        case ("deadline"):
            nameLength = 8;
            int indexBy = message.indexOf("/");
            return new Deadline(message.substring(nameLength + 1, indexBy - 1),
                    message.substring(indexBy + 1));
        case ("event"):
            nameLength = 5;
            int indexAt = message.indexOf("/");
            return new Event(message.substring(nameLength + 1, indexAt - 1),
                    message.substring(indexAt + 1));
        default:
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
        
        Scanner in = new Scanner(System.in);       
        
        printWelcomeMessage();
        
        Task[] tasks = new Task[100];
        int index = 0;
        String enteredMessage = in.nextLine();

        while(!enteredMessage.equals("bye")){
            if (enteredMessage.equals("list")){
                echoList(tasks);
            } else if (enteredMessage.startsWith("done")) {
                int itemIndex = Integer.parseInt(enteredMessage.substring(5)) - 1;
                changeStatus(tasks[itemIndex]);
            } else de{
                tasks[index] = createType(enteredMessage);
                echoMessage(tasks[index], index);
                index++;
            }
            enteredMessage = in.nextLine();
        }

        printByeMessage();
    }
}
