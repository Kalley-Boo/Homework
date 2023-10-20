
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private final String description;
    private final LocalDateTime timestamp;

    //------------------------constructors----------------------------
    //not sure how to put the validation outside of the constructor, since there are no setters
    public EventLog(String description){
        if(description == null || description.trim().isEmpty()){
            throw new IllegalArgumentException("Description cannot be empty");
        }
        this.description = description;
        this.timestamp = LocalDateTime.now();
    }
    public EventLog(){
        throw new IllegalArgumentException("Description cannot be empty");
    }
    //---------------------------getters------------------------------
    //no setters due to final
    public String getDescription(){
        return description;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    //----------------------------methods----------------------------------
    public String viewInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String formattedTimestamp =timestamp.format(formatter);
        return "[" + formattedTimestamp + "] " + description;
    }
}
