package com.example.demo.service;

import com.example.demo.models.RegisterDetails;
import com.example.demo.models.Task;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public String assignTask(int empId, Task task) {
        RegisterDetails employee = employeeRepository.findById(empId).orElse(null);
        if (employee == null) {
            return "Employee not found";
        }
        task.setEmployee(employee);
        taskRepository.save(task);
        return "Task assigned successfully";
    }
}
