package com.smart_city.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.smart_city.Dao.UserRepository;
import com.smart_city.Entity.User;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	 private PasswordEncoder passwordEncoder;
	
	  // Register a new user
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // Encrypt the password
        userRepository.save(user);  // Save user to the database
    }
	
	
	 // Authenticate user by username and password
	public String authenticateUser(String username, String password ) {
		Optional<User> userOpt = userRepository.findByUsername(username);
				  if (userOpt.isPresent()) {
			            User user = userOpt.get();
			            
			            if (passwordEncoder.matches(password, user.getPassword())) {
			                return "Login successful!";
			            }
				   }
        return "Invalid username or password!";
    }

	

}
