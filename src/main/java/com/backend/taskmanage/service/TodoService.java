package com.backend.taskmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.backend.taskmanage.controller.CountResponse;
import com.backend.taskmanage.controller.TodoCreateRequest;
import com.backend.taskmanage.controller.TodoUpdateRequest;

import com.backend.taskmanage.errorhandler.ResourceNotFoundException;
import com.backend.taskmanage.entities.Todo;
import com.backend.taskmanage.repository.TodoRepository;
import com.backend.taskmanage.repository.TodoPagingRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	
	@Autowired
	private TodoPagingRepository todoPagingRepository;
	

	 public Todo create(TodoCreateRequest todoCreateRequest, String username) {
	        Todo todo = new Todo(
	                username,
	                todoCreateRequest.getTitle(),
	                todoCreateRequest.getTargetDate(),
	                todoCreateRequest.getDescription() // Consistent getter method naming
	        );
	        return todoRepository.save(todo);
	    }
	public Todo readById(long id, String username) {
		Todo todo = todoRepository.findByUsernameAndId(username, id);
		if(todo == null) {
			throw new ResourceNotFoundException("Todo not found");
		}
		return todo;
	}
	public List<Todo> readAll(String username) {
	   
	    return todoRepository.findByUsername(username);
	}

	public List<Todo> readAllByIsCompleted(String username, String isCompleted) {
	    boolean completed = Boolean.parseBoolean(isCompleted);
	   
	    return todoRepository.findByUsernameAndIsCompleted(username, completed);
	}

	


	
	public void deleteById(long id, String username) {
		Todo todo = todoRepository.findByUsernameAndId(username, id);
		if(todo == null) {
			throw new ResourceNotFoundException("Todo not found");
		}
		todoRepository.deleteById(id);
	}
	
	public Todo updateById(long id, TodoUpdateRequest todoUpdateRequest, String username) {
		Todo todo = todoRepository.findByUsernameAndId(username, id);
		if(todo == null) {
			throw new ResourceNotFoundException("Todo not found");
		}
		
		todo.setTitle(todoUpdateRequest.getTitle());
		todo.setTargetDate(todoUpdateRequest.getTargetDate());
		todo.setDescription(todoUpdateRequest.getDescription());
		return todoRepository.save(todo);
	}
	
	public Todo markCompleteById(long id, String username) {
		Todo todo = todoRepository.findByUsernameAndId(username, id);
		if(todo == null) {
			throw new ResourceNotFoundException("Todo not found");
		}
		
		todo.setIsCompleted(!todo.getIsCompleted());
		return todoRepository.save(todo);
	}
	
	public CountResponse countAll(String username) {
		return new CountResponse(todoRepository.countByUsername(username));
	}

}
