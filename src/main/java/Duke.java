public class Duke {

    private static final String FILEPATH = "duke.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList();
    }

    public void run(){
        storage.loadFromFile(tasks);
        ui.printWelcomeMessage();
        ui.dealWithInput(tasks);
        storage.saveToFile(tasks);
    }

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
