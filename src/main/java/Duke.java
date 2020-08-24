import java.util.Scanner;

public class Duke {
    
    //print the horizontal line
    public static void horizontalLine(){
        String straightLine = "-------------------------------------------";
        System.out.println(straightLine);
    }

    //print a welcome message
    public static void welcomeMessage(){
        horizontalLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        horizontalLine();  
    }
    
    //print a goodbye message
    public static void byeMessage(){
        horizontalLine();
        System.out.println("Bye. Hope to see you again soon!\n");
        horizontalLine();
    }
    
    //echo the message
    public static void echoMessage(String message){
        horizontalLine();
        System.out.println("added: " + message + "\n");
        horizontalLine();
    }
    
    //echo the list
    public static void echoList(String[] tasks){
        horizontalLine();

        int index = 0;
        while (tasks[index] != null && index < tasks.length){
            if (tasks[index].equals("list")){
                break;
            }
            
            System.out.println((index + 1) +". " + tasks[index]);
            index++;
        }

        System.out.println();
        horizontalLine();
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        
        Scanner in = new Scanner(System.in);       
        
        welcomeMessage();
        
        String[] tasks = new String[100];
        int index = 0;

        tasks[index] = in.nextLine();
        while (tasks[index] != null && !tasks[index].equals("bye")) {
            if (tasks[index].equals("list")) {
                echoList(tasks);
                index--;
            } else {
                echoMessage(tasks[index]);
            }          

            index++;
            tasks[index] = in.nextLine();
        }
        
        byeMessage();
    }
}