package com.backend.taskmanage.controller;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TodoUpdateRequest {

    @NotEmpty(message = "Title is required")
    private String title;

    @NotNull(message = "Target date is required")
    private Date targetDate;
    
    @NotEmpty(message = "Description is required")  // Corrected validation message
    private String description;

    public TodoUpdateRequest() {
    }

    public TodoUpdateRequest(String title, Date targetDate, String description) {
        this.title = title;
        this.targetDate = targetDate;
        this.description = description;
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

    public String getDescription() {  // Renamed getter to follow Java naming conventions
        return description;
    }

    public void setDescription(String description) {  // Renamed setter to follow Java naming conventions
        this.description = description;
    }
}
