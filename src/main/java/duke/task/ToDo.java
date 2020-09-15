package duke.task;

public class ToDo extends Task {
    public ToDo(String description){
        super(description);
    }

    @Override
    public String saveToFile(){
        return "T|" + isDone + "|" + this.description + "\n";
    }

    @Override
    public String toString(){
        return "[T]" + super.toString();
    }
}
