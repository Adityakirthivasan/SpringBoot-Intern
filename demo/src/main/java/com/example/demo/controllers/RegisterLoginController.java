//Day 6
package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class RegisterLoginController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody Employee emp) {
        // Encrypt the password
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));

        // Save the employee to DB
        employeeRepo.save(emp);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login() {
        // Login is handled by Spring Security using Basic Auth
        return "Login successful (verified via Spring Security)";
    }
}
