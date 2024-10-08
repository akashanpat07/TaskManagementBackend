package com.backend.taskmanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.taskmanage.entities.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	List<Todo> findAllByUsername(String username);
	List<Todo> findAllByUsernameAndIsCompleted(String username, boolean isCompleted);
	
	Todo findByUsernameAndId(String username, long Id);
	
	Long countByUsername(String username);
	Long countByUsernameAndIsCompleted(String username, boolean isCompleted);
	List<Todo> findByUsername(String username);

	List<Todo> findByUsernameAndIsCompleted(String username, boolean isCompleted);
}
