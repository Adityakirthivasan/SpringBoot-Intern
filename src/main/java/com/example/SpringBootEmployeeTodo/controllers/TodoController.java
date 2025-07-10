package com.example.SpringBootEmployeeTodo.controllers;

import com.example.SpringBootEmployeeTodo.models.Todo;
import com.example.SpringBootEmployeeTodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepo;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepo.save(todo);
    }

    @GetMapping("/{empid}")
    public List<Todo> getTodosByEmployee(@PathVariable Long empid) {
        return todoRepo.findByEmployeeEmpid(empid);
    }
}
