package duke.task;
import duke.oop.Parser;

public class Event extends Task {
    protected String at;
    protected Parser parser;

    public Event(String description, String at){
        super(description);
        this.at = parser.setDateFormat(at);
    }

    @Override
    public String saveToFile(){
        return "E|" + isDone + "|" + this.description + "|" + this.at + "\n";
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
