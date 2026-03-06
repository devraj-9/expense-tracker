package com.smartexpense.controller;

import com.smartexpense.dto.AuthRequest;
import com.smartexpense.dto.AuthResponse;
import com.smartexpense.dto.RefreshRequest;
import com.smartexpense.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authService.register(name, email, password));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestBody RefreshRequest request) {
        return ResponseEntity.ok(authService.refresh(request));
    }
}
