package com.backend.taskmanage.controller;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class TodoCreateRequest {
	@NotEmpty(message = "Title is required")
	private String title;

	@NotNull(message = "Target date is required")
	private Date targetDate;
	@NotEmpty(message = "desc date is required")
	private String description;
	protected TodoCreateRequest() {
		
	}

	public TodoCreateRequest(String title, Date targetDate,String description) {
		super();
		this.title = title;
		this.targetDate = targetDate;
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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
}