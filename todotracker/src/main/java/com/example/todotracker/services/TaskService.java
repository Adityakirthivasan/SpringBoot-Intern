
//updated day4
package com.example.todotracker.services;

import com.example.todotracker.models.Task;
import com.example.todotracker.repo.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        task.setStatus(Task.Status.YET_TO_START);
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateStatus(Long id, Task.Status status) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setStatus(status);
        return repository.save(task);
    }

    public String deleteTask(Long id) {
        repository.deleteById(id);
        return "Task deleted";
    }
}

