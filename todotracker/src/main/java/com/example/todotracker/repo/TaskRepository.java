// updated day4
package com.example.todotracker.repo;

import com.example.todotracker.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository provides CRUD and pagination methods
public interface TaskRepository extends JpaRepository<Task, Long> {
    // No need to add anything here unless you want custom queries
}
