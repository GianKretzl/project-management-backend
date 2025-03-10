package com.sg.gksolution.project_management_system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sg.gksolution.project_management_system.entities.User;
import com.sg.gksolution.project_management_system.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
