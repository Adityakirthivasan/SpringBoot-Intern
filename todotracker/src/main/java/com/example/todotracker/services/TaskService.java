package com.example.todotracker.services;
import com.example.todotracker.models.Task;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class TaskService {
    private final List<Task>tasks=new ArrayList<>();
    private final AtomicLong counter=new AtomicLong();
    public Task createTask(Task task){
        task.setId(counter.incrementAndGet());
        task.setStatus(Task.Status.YET_TO_START);
        tasks.add(task);
        return task;
    }
    public List<Task> getAllTasks() {
        return tasks;
    }
    public Task updateStatus(Long id, Task.Status status) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                task.setStatus(status);
                return task;
            }
        }
        throw new RuntimeException("Task not found");
    }
    public String deleteTask(Long id) {
        tasks.removeIf(t -> t.getId().equals(id));
        return "Task deleted";
    }


}
