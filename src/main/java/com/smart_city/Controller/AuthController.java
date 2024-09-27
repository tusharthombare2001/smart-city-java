package com.smart_city.Controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smart_city.Entity.LoginRequest;
import com.smart_city.Entity.User;
import com.smart_city.Service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class AuthController{
	private static final Logger log = LoggerFactory.getLogger(AuthController.class);
	 private final AuthenticationManager authenticationManager;

	 
	 @Autowired
	    public AuthController(AuthenticationManager authenticationManager) {
	        this.authenticationManager = authenticationManager;
	    }
	 
	
	   
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
        try {
            String response = userService.authenticateUser(loginRequest.get("username"), loginRequest.get("password")); // Call service to authenticate user
            if (response.equals("Login successful!")) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            System.err.println("Error during user login: " + e.getMessage());  // Improved error logging
            e.printStackTrace();  // Print the stack trace for detailed error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login failed: " + e.getMessage());
        }
    }
        @GetMapping("/login")
        public String login() {
            return "login"; // This should return the name of the view
        }
//        
}






















































