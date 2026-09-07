package com.example.intern_demo.service;

import com.example.intern_demo.model.User;
import com.example.intern_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Read All
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Read Single
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}