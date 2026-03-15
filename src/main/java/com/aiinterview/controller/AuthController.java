package com.aiinterview.controller;

import com.aiinterview.dto.LoginRequest;
import com.aiinterview.dto.InterviewResponse.AuthResponse;
import com.aiinterview.entity.User;
import com.aiinterview.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        User savedUser = authService.register(user);

        return ResponseEntity.ok(savedUser);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody LoginRequest request) {

        AuthResponse response = authService.login(request);

        return ResponseEntity.ok(response);
    }
}