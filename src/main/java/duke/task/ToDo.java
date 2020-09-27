package duke.task;

public class ToDo extends Task {
    /**
     * A instructor of a todo task
     *
     * @param description the description of the task
     */
    public ToDo(String description){
        super(description);
    }

    /**
     * Change the format of todo task to save into the file
     *
     * @return the String to be saved in file
     */
    @Override
    public String saveToFile(){
        return "T|" + isDone + "|" + this.description + "\n";
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
