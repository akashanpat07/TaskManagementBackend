package com.backend.taskmanage.entities;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Todo {

    @Id
    @GeneratedValue
    private long id;
    
    private String username;
    
    @NotEmpty(message = "Title is required")
    private String title;
    
    @NotEmpty(message = "Description is required") // Fixed typo in validation message
    private String description;
    
    @NotNull(message = "Target date is required")
    private Date targetDate;

    private boolean isCompleted;

    protected Todo() {
    }

    public Todo(String username, String title, Date targetDate, String description) {
        this.title = title;
        this.targetDate = targetDate;
        this.username = username;
        this.description = description;
        this.isCompleted = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { // Renamed setter method to setId
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getDescription() { // Getter method for description
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", title=" + title + ", targetDate=" + targetDate + ",description=" + description + " username=" + username
                + ", isCompleted=" + isCompleted + "]";
    }
}
