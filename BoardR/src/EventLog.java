
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventLog {
    private final String description;
    private final LocalDateTime timestamp;

    //------------------------constructors----------------------------
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
    public String getDescription(){
        return description;
    }
    public LocalDateTime getTimestamp(){
        return timestamp;
    }
    public String viewInfo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String formattedTimestamp =timestamp.format(formatter);
        return "[" + formattedTimestamp + "] " + description;
    }
}
