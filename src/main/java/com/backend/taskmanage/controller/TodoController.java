package com.backend.taskmanage.controller;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.taskmanage.entities.Todo;
import com.backend.taskmanage.repository.TodoRepository;
import com.backend.taskmanage.service.TodoService;


@RestController

@CrossOrigin(origins = "https://taskmanagementapp-five.vercel.app", allowCredentials = "true")
public class TodoController {
	@Autowired
	private TodoService todoService;
	@Autowired
	private TodoRepository TodoRepositoryy;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/api/todo")
	public ResponseEntity<Todo> create(@Valid @RequestBody TodoCreateRequest todoCreateRequest, Principal principal) {
		return new ResponseEntity<>(todoService.create(todoCreateRequest, principal.getName()), HttpStatus.CREATED);
	}
	

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/api/todo")
	public ResponseEntity<List<Todo>> readAll(Principal principal, @RequestParam(required = false) String isCompleted) {
	    List<Todo> todos;
	    
	    if (isCompleted != null) {
	        todos = todoService.readAllByIsCompleted(principal.getName(), isCompleted);
	    } else {
	        todos = todoService.readAll(principal.getName());
	    }
	    
	    return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/api/todo/{id}/markcomplete")
	public ResponseEntity<Todo> markComplete(@PathVariable long id, Principal principal) {
		return new ResponseEntity<>(todoService.markCompleteById(id, principal.getName()), HttpStatus.OK);
	}
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/api/todo/count")
	public ResponseEntity<CountResponse> countAll(Principal principal, @RequestParam(required = false) String isCompleted){

		return new ResponseEntity<>(todoService.countAll(principal.getName()), HttpStatus.OK);
	}
	

	
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("/api/todo/{id}")
	public ResponseEntity<Todo> read(@PathVariable long id, Principal principal) {
		return new ResponseEntity<>(todoService.readById(id, principal.getName()), HttpStatus.OK);
	}
	
	
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping("/api/todo/{id}")
	public ResponseEntity<Todo> update(@PathVariable long id, @Valid @RequestBody TodoUpdateRequest todoUpdateRequest, Principal principal) {
		return new ResponseEntity<>(todoService.updateById(id, todoUpdateRequest, principal.getName()), HttpStatus.OK);
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/api/todo/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id, Principal principal) {
		todoService.deleteById(id, principal.getName());
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
	}
}
