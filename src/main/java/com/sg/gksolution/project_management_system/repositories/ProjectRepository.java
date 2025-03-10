package com.sg.gksolution.project_management_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.gksolution.project_management_system.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
