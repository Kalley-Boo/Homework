import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;

enum Status {
    OPEN, TODO, IN_PROGRESS, DONE, VERIFIED
}

public class BoardItem {
    private String title;
    private LocalDate dueDate;
    private Status status;
    private final List<EventLog> eventLogs;
    //----------------constructor---------------------
    public BoardItem(String title, LocalDate dueDate){
        this.eventLogs = new ArrayList<>();
        eventLogs.add(new EventLog("Item created: '" + title + "', [" + status + " | " + dueDate + "]"));
        //Initilised before the setters for title and dueDate, since it was giving an
        //nullpointer exeption if initilised after since trying to put an event/title without first initilising the list
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.OPEN;
    }
    //-----------------methods-----------------------
    private void addEventLog(String message){
        eventLogs.add(new EventLog(message));
    }
    public void revertStatus(){
        Status previous = status;
        if(status.ordinal() > Status.OPEN.ordinal()){
            status = Status.values()[status.ordinal() - 1];
            addEventLog("Status changed from " + previous + " to " + status);
        } else {
            addEventLog("Can't revert, already at Open");
        }
    }

    public void advanceStatus(){
        Status previous = status;
        if(status.ordinal() < status.VERIFIED.ordinal()){
            status = Status.values()[status.ordinal() + 1];
            addEventLog("Status changed from " + previous + " to " + status);
        } else {
            addEventLog("Can't advance, already at Verified");
        }
    }

    public void displayHistory(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        for(EventLog log : eventLogs){
            String formattedTimestamp = log.getTimestamp().format(formatter);
            System.out.println("[" + formattedTimestamp + "]" + log.getDescription());
        }
    }

    public String viewInfo(){
        return "'" + title + "', [" + status.name() + " | " + dueDate + "]";
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }
    //-----------------------setters and getters------------------------
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        if(title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(title.length() < 5 || title.length() > 30){
            throw new IllegalArgumentException("Title length should be between 5 and 30 characters");
        }
        String previousTitle = this.title;
        this.title = title;
        if(previousTitle != null) {
            addEventLog("Title changed from '" + previousTitle + "' to '" + title + "'");
        }
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate){
        if(dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Due date cannot be in the past");
        }
        LocalDate previousDueDate = this.dueDate;
        this.dueDate = dueDate;
        if(previousDueDate != null) {
            addEventLog("Due date changed from " + previousDueDate + " to " + dueDate);
        }

    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
