import java.util.Scanner;

public class Duke {
    
    //print a welcome message
    public static void welcomeMessage(){
        String straightLine = "-------------------------------------------";
        System.out.println(straightLine);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        System.out.println(straightLine);   
    }
    
    //print a goodbye message
    public static void byeMessage(){
        String straightLine = "-------------------------------------------";
        System.out.println(straightLine);
        System.out.println("Bye. Hope to see you again soon!\n");
        System.out.println(straightLine);
    }
    
    //echo the message
    public static void echoMessage(String message){
        String straightLine = "-------------------------------------------";
        System.out.println(straightLine);
        System.out.println(message + "\n");
        System.out.println(straightLine);
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
        
        String command = in.nextLine();
        while (command != null && !command.equals("bye")) {
            echoMessage(command);
            command = in.nextLine();
        }
        
        byeMessage();
    }
}
