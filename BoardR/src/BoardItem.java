import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

enum Status {
    Open, Todo, InProgress, Done, Verified
}

public class BoardItem {
    public String title;
    public LocalDate dueDate;
    public Status status;

    public BoardItem(String title, LocalDate dueDate){
        if (title == null || title.trim().isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if(title.length() < 5 || title.length() > 30){
            throw new IllegalArgumentException("Title length should be between 5 and 30 characters");
        }
        if(dueDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Due date connot be in the past");
        }
        this.title = title;
        this.dueDate = dueDate;
        this.status = Status.Open;
    }

    public void revertStatus(){
        if(status.ordinal() > Status.Open.ordinal()){
            status = Status.values()[status.ordinal() - 1];
        }
    }

    public void advanceStatus(){
        if(status.ordinal() < status.Verified.ordinal()){
            status = Status.values()[status.ordinal() + 1];
        }
    }

    public String viewInfo(){
        return "'" + title + "', [" + status.name() + " | " + dueDate + "]";
    }

    public void updateStatus(Status newStatus) {
        this.status = newStatus;
    }
}
