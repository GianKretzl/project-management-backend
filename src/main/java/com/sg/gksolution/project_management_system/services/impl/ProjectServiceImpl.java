package com.sg.gksolution.project_management_system.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sg.gksolution.project_management_system.entities.Project;
import com.sg.gksolution.project_management_system.repositories.ProjectRepository;
import com.sg.gksolution.project_management_system.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Optional<Project> getProjectById(Long id) { // Implemente este método
        return projectRepository.findById(id);
    }
}