
//updated day4
package com.example.todotracker.controllers;

import com.example.todotracker.models.Task;
import com.example.todotracker.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestParam Task.Status status) {
        return service.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        return service.deleteTask(id);
    }
}
