package com.sg.gksolution.project_management_system.services;

import java.util.List;
import java.util.Optional;

import com.sg.gksolution.project_management_system.entities.Project;

public interface ProjectService {
    List<Project> getAllProjects();
    Project saveProject(Project project);
    void deleteProject(Long id);
    Optional<Project> getProjectById(Long id); // Adicione este método
}
