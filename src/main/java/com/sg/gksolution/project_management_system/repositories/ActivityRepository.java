package com.sg.gksolution.project_management_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.gksolution.project_management_system.entities.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByProjectId(Long projectId);
}

