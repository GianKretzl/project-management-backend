package com.sg.gksolution.project_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.gksolution.project_management_system.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);    
}

