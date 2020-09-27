package duke.task;
import duke.oop.Parser;

public class Event extends Task {
    protected String at;
    protected Parser parser;

    /**
     * A constructor of the event task
     *
     * @param description the String description of the task
     * @param at the date and time of the task
     */
    public Event(String description, String at){
        super(description);
        this.at = parser.setDateFormat(at);
    }

    /**
     * Change the format of the event task to save in the file
     *
     * @return the String to be saved in file
     */
    @Override
    public String saveToFile(){
        return "E|" + isDone + "|" + this.description + "|" + this.at + "\n";
    }

    @Override
    public String toString(){
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
