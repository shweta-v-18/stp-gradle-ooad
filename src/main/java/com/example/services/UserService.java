package com.example.services;

import com.example.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // Register and save the user in the database
    public User registerUser(User user) {
        return userRepository.save(user);  // Saves user to MySQL
    }

    // Check login credentials
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;  // Login successful
        }
        return null;  // Login failed
    }
}
