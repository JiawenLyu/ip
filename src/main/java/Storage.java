import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String filepath;
    private static File f;

    public Storage (String filepath){
        this.filepath = filepath;
        f = new File(filepath);
    }

    /**
     * Save the information of all the tasks to the file.
     *
     * @param tasks task list contains all the information about the tasks
     */
    public static void saveToFile(TaskList tasks){
        try{
            FileWriter fw = new FileWriter(filepath);
            ArrayList<Task> tasksList = tasks.getTasksList();
            for (Task task: tasksList){
                fw.write(task.saveToFile());
            }
            fw.close();
        } catch (IOException e){
            Ui.printHorizontalLine();
            System.out.println("Something went wrong: " + e.getMessage() + "\n");
            Ui.printHorizontalLine();
        }
    }

    /**
     * Load all the information about tasks to the file
     *
     * @param tasks the task list to load the the information to
     */
    public void loadFromFile(TaskList tasks){
        try{
            if (!f.exists()){
                f.createNewFile();
            }
            Scanner s = new Scanner(f);
            Task task;
            while(s.hasNext()){
                String[] readTask = s.nextLine().split("\\|");
                int INDEX_OF_TYPE = 0;
                int INDEX_OF_STATUS = 1;
                int INDEX_OF_BODY = 2;
                int INDEX_OF_TIME = 3;
                switch (readTask[INDEX_OF_TYPE]) {
                case ("T"):
                    task = new ToDo(readTask[INDEX_OF_BODY]);
                    break;
                case ("D"):
                    task = new Deadline(readTask[INDEX_OF_BODY], readTask[INDEX_OF_TIME]);
                    break;
                case ("E"):
                    task = new Event(readTask[INDEX_OF_BODY], readTask[INDEX_OF_TIME]);
                    break;
                default:
                    task = new Task(readTask[INDEX_OF_BODY]);
                }

                if (readTask[INDEX_OF_STATUS].equals("true")){
                    task.setIsDone(true);
                }
                tasks.add(task);
            }
        } catch (FileNotFoundException e){
            Ui.printHorizontalLine();
            System.out.println("File not found\n");
            Ui.printHorizontalLine();
        } catch (IOException e){
            e.printStackTrace();
            Ui.printHorizontalLine();
            System.out.println("File creation failed\n");
            Ui.printHorizontalLine();
        }
    }

}
