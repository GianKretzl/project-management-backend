package com.sg.gksolution.project_management_system.services;

import java.util.List;
import java.util.Optional;

import com.sg.gksolution.project_management_system.entities.Activity;

public interface ActivityService {
    List<Activity> getAllActivities();
    Activity saveActivity(Activity activity);
    Optional<Activity> getActivityById(Long id);
    void deleteActivityById(Long id);
    List<Activity> getActivitiesByProjectId(Long projectId);
}