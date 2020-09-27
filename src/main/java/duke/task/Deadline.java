package duke.task;
import duke.oop.Parser;
public class Deadline extends Task {
    protected String by;
    protected Parser parser;

    public Deadline(String description, String by){
        super(description);
        this.by = parser.setDateFormat(by);
    }

    @Override
    public String saveToFile(){
        return "D|" + isDone + "|" + this.description + "|" + this.by + "\n";
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
