package duke.task;


public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription(){
        return description;
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String saveToFile(){
        return "T|" + isDone + "|" + this.description + "\n";
    }

    @Override
    public String toString(){
        return "[" + this.getStatusIcon() + "]" + this.description;
    }
}