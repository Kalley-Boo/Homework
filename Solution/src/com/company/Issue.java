package com.company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Issue extends BoardItem{
    private String description;

    public Issue(String title, String description, LocalDate dueDate) {
        super(title, dueDate, Status.OPEN);
        setDescription(description);
    }

    private void setDescription(String description){
        if(description == null){
            this.description = "No description";
        } else {
            this.description = description;
        }
        logEvent(String.format("Item created: %s [%s]", viewInfo(), description));
    }

    public String viewInfo(){
        return String.format("'%s', [%s | %s]", getTitle(), getStatus(), getDueDate().format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy")));
    }
}
