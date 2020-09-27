package duke.oop;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class TaskList {
    private static ArrayList<Task> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void add(Task task){
        tasks.add(task);
    }


    public void delete(String command){
        int numberIndex = 7;
        int index = Integer.parseInt(command.substring(numberIndex)) - 1;
        try {
            if (index > tasks.size() - 1 || index < 0){
                throw new DukeException();
            }
            Ui.printHorizontalLine();
            System.out.println("Noted. I've removed this task: ");
            System.out.println(tasks.get(index).toString());
            tasks.remove(index);
            System.out.println("Now you have " + tasks.size() + " items in the list.\n");
            Ui.printHorizontalLine();
         } catch (DukeException e) {
            Ui.printHorizontalLine();
            System.out.println("OOPS!!! The index is invalid.\n");
            Ui.printHorizontalLine();
        }
    }

    public ArrayList<Task> getTasksList(){
        return tasks;
    }

    public void echoList() {
        Ui.printHorizontalLine();
        int index = 0;
        for (Task task : tasks) {
            System.out.println((index + 1) + ". " + task.toString());
            index++;
        }
        System.out.println();
        Ui.printHorizontalLine();
    }

    public void done(String command){
        int numberIndex = 5;
        int itemIndex = Integer.parseInt(command.substring(numberIndex)) - 1;
        try {
            if (itemIndex > tasks.size() - 1 || itemIndex < 0){
                throw new DukeException();
            } else {
                Ui.printHorizontalLine();
                System.out.println("Nice! I've marked this task as done:");
                tasks.get(itemIndex).setIsDone(true);
                System.out.println(tasks.get(itemIndex).toString());
                System.out.println();
                Ui.printHorizontalLine();
            }
        } catch (DukeException e) {
            Ui.printHorizontalLine();
            System.out.println("OOPS!!! The index is invalid.\n");
            Ui.printHorizontalLine();
        }
    }

    public void addTodo(String command){
        int nameLength = 4;
        Task task = new ToDo(command.substring(nameLength + 1));
        tasks.add(task);
        Ui.printHorizontalLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list");
        Ui.printHorizontalLine();
    }

    public void addEvent(String command){
        int nameLength = 5;
        int indexAt = command.indexOf("/");
        int distanceAfterAt = 4;
        Task task = new Event(command.substring(nameLength + 1, indexAt - 1),
                command.substring(indexAt + distanceAfterAt));
        tasks.add(task);
        Ui.printHorizontalLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list");
        Ui.printHorizontalLine();
    }

    public static void addDeadline(String command) {
        int nameLength = 8;
        int indexBy = command.indexOf("/");
        int distanceAfterBy = 4;
        Task task = new Deadline(command.substring(nameLength + 1, indexBy - 1),
                command.substring(indexBy + distanceAfterBy));
        tasks.add(task);
        Ui.printHorizontalLine();
        System.out.println("Got it. I've added this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in the list");
        Ui.printHorizontalLine();
    }

    public static void findTasks(String command){
        int nameLength = 4;
        String keyWord = command.substring(nameLength + 1);
        ArrayList<Task> keywordTasks = (ArrayList<Task>) tasks.stream()
                .filter((t) -> t.getDescription().contains(keyWord))
                .collect(Collectors.toList());
        Ui.printHorizontalLine();
        System.out.println("Here are the matching tasks in your list:");
        int index = 1;
        for (Task task : keywordTasks) {
            System.out.println(index + "." + task);
        }
        System.out.println();
        Ui.printHorizontalLine();
    }
}
