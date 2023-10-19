import java.time.LocalDate;
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
        setTitle(title);
        setDueDate(dueDate);
        this.status = Status.OPEN;
        this.eventLogs = new ArrayList<>();
        eventLogs.add(new EventLog("Item created: '" + title + "', [" + status + " | " + dueDate + "]"));
    }
    //-----------------methods-----------------------
    public void revertStatus(){
        if(status.ordinal() > Status.OPEN.ordinal()){
            status = Status.values()[status.ordinal() - 1];
        }
    }

    public void advanceStatus(){
        if(status.ordinal() < status.VERIFIED.ordinal()){
            status = Status.values()[status.ordinal() + 1];
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
        this.title = title;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate){
        if(dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Due date cannot be in the past");
        }
        this.dueDate = dueDate;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
