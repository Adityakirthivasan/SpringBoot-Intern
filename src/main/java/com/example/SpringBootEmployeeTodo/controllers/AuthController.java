package com.example.SpringBootEmployeeTodo.controllers;

import com.example.SpringBootEmployeeTodo.models.RegisterDetails;
import com.example.SpringBootEmployeeTodo.models.UserDetailsDto;
import com.example.SpringBootEmployeeTodo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody UserDetailsDto user) {
        return authService.addNewEmployee(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody RegisterDetails user) {
        return authService.authenticate(user);
    }
}
