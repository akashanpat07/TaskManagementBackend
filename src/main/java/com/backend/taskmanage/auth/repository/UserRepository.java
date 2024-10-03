package com.backend.taskmanage.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.taskmanage.auth.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}