package com.foodapp.controller;

import com.foodapp.model.User;
import com.foodapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        User user = userService.registerUser(
            request.get("username"),
            request.get("email"),
            request.get("password")
        );
        return ResponseEntity.ok(Map.of(
            "message", "Registration successful!",
            "userId", user.getId()
        ));
    }
}