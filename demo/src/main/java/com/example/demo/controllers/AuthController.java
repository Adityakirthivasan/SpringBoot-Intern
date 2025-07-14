//Day10
package com.example.demo.controllers;

import com.example.demo.models.JwtResponse;
import com.example.demo.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
}
