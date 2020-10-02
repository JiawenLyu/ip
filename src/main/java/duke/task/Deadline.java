package duke.task;
import duke.oop.Parser;
public class Deadline extends Task {
    protected String by;
    protected Parser parser;

    /**
     * A constructor of the deadline task
     *
     * @param description the String description of the task
     * @param by the deadline of the task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parser.setDateFormat(by);
    }

    /**
     * Change the format of the deadline task to save in the file
     *
     * @return the String to be saved in file
     */
    @Override
    public String saveToFile(){
        return "D|" + isDone + "|" + this.description + "|" + this.by + "\n";
    }

    @Override
    public String toString(){
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}
