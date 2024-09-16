package com.smart_city.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart_city.Entity.User;
import com.smart_city.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class AuthController {
	@Autowired
	private UserService userService;
	
	// Register a new user
    @PostMapping("/api/auth/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);  // Call service to register user
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }
    
    
    // Login a user
    @PostMapping("/api/auth/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginRequest) {
        String response = userService.authenticateUser(loginRequest.get("username"), loginRequest.get("password"));  // Call service to authenticate user
        if (response.equals("Login successful!")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}

