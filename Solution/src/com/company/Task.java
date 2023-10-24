package com.company;

import java.time.LocalDate;

public class Task extends BoardItem{
    private static final int ASSIGNEE_MIN_LENGTH = 5;
    private static final int ASSIGNEE_MAX_LENGHT = 30;

    private String assignee;

    public Task(String title, String assignee, LocalDate dueDate) {
        super(title, dueDate, Status.TODO);
        validateAssignee(assignee);
        this.assignee = assignee;
    }

    public String getAssignee(){
        return assignee;
    }

    public void setAssignee(String assignee){
        if(this.assignee != null) {
            logEvent(String.format("Assignee changed from %s to %s", getAssignee(), assignee));
        }
        this.assignee = assignee;
    }

    public void validateAssignee(String assignee){
        if (assignee == null) {
            throw new IllegalArgumentException("Assignee name should not be null!");
        }else if(assignee.length() < ASSIGNEE_MIN_LENGTH || assignee.length() > ASSIGNEE_MAX_LENGHT){
            throw new IllegalArgumentException(String.format(
                    "Please provide an assignee name with length between %d and %d chars",
                    ASSIGNEE_MIN_LENGTH, ASSIGNEE_MAX_LENGHT));
        }
    }

    public String viewInfo(){
        return String.format("'%s', [%s | %s]", getTitle(), getStatus(), getDueDate());
    }
}
