package com.example.SpringBootEmployeeTodo.controllers;

import com.example.SpringBootEmployeeTodo.models.RegisterDetails;
import com.example.SpringBootEmployeeTodo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String home() {
        return "Welcome to SpringBoot Security";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public List<RegisterDetails> getAll() {
        return employeeService.getMethod();
    }

    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public RegisterDetails getById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/employee")
    @PreAuthorize("hasRole('ADMIN')")
    public String add(@RequestBody RegisterDetails emp) {
        return employeeService.addEmployee(emp);
    }

    @PutMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(@PathVariable int empId, @RequestBody RegisterDetails updatedEmp) {
        return employeeService.updateEmployee(empId, updatedEmp);
    }

    @DeleteMapping("/employee/{empId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable int empId) {
        return employeeService.deleteEmployeeById(empId);
    }
}
