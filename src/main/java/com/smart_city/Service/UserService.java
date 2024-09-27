package com.smart_city.Service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart_city.Dao.UserRepository;
import com.smart_city.Entity.User;



@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;


	
	  // Register a new user
	 public void registerUser(User user) {
	        userRepository.save(user);
	    }
	  // Authenticate a user
	    public String authenticateUser(String username, String password) {
	        User user = userRepository.findByUsername(username);
	        if (user != null) {
	            System.out.println("User found: " + user.getUsername());  // Debugging log

	            if (user.getPassword().equals(password)) {
	                System.out.println("Password match");  // Debugging log
	                return "Login successful!";
	            } else {
	                System.out.println("Invalid password");  // Debugging log
	                return "Invalid username or password!";
	            }
	        } else {
	            System.out.println("User not found");  // Debugging log
	            return "Invalid username or password!";
	        }
	    }
	    
	    private String hashPassword(String password) {
	        // Use a password hashing library such as BCrypt
	        return BCrypt.hashpw(password, BCrypt.gensalt());
	    }

	    // Helper method to check password
	    private boolean checkPassword(String plainPassword, String hashedPassword) {
	        // Compare hashed password
	        return BCrypt.checkpw(plainPassword, hashedPassword);
	    }
	}


































