package duke.task;

public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * A constructor of a task with description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Set the state of the task
     *
     * @param isDone the status of the task
     */
    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    /**
     * Change the format of the task to save in the file
     *
     * @return the String to be saved in file
     */
    public String saveToFile(){
        return "T|" + isDone + "|" + this.description + "\n";
    }

    @Override
    public String toString(){
        return "[" + this.getStatusIcon() + "]" + this.description;
    }
}