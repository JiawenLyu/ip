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

    /**
     * Get the description of the task
     *
     * @return string description of the task
     */
    public String getDescription() {
        return description;
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

    /**
     * Print the information of the task in a format
     *
     * @return the string contains the information of the task
     */
    @Override
    public String toString(){
        return "[" + this.getStatusIcon() + "]" + this.description;
    }
}