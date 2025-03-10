package com.sg.gksolution.project_management_system.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sg.gksolution.project_management_system.entities.Activity;
import com.sg.gksolution.project_management_system.repositories.ActivityRepository;
import com.sg.gksolution.project_management_system.services.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Optional<Activity> getActivityById(Long id) {
        return activityRepository.findById(id);
    }

    @Override
    public void deleteActivityById(Long id) {
        activityRepository.deleteById(id);
    }

    @Override
    public List<Activity> getActivitiesByProjectId(Long projectId) {
        return activityRepository.findByProjectId(projectId);
    }
}