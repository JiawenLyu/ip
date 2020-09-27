package duke;

import duke.oop.Storage;
import duke.oop.TaskList;
import duke.oop.Ui;

/**
 * Main class of the application.
 * A task manager to manage tasks including deadlines, todos, and events.
 * It has functions like add tasks, delete tasks, mark a task as done,
 * list all tasks, and find tasks you have with specific keywords.
 */
public class Duke {

    private static final String FILEPATH = "duke.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for Duck class.
     *
     * @param filePath the path of the file to store and restore the tasks information
     */
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    /**
     * Run the program.
     */
    public void run(){
        storage.loadFromFile(tasks);
        ui.printWelcomeMessage();
        ui.dealWithInput(tasks);
        storage.saveToFile(tasks);
    }

    /**
     * Main program to start the application.
     * Initialise a Duck object and run it.
     *
     * @param args input arguments
     */
    public static void main(String[] args) {

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        new Duke(FILEPATH).run();
    }
}
