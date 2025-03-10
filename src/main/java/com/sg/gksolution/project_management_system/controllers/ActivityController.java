package com.sg.gksolution.project_management_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gksolution.project_management_system.entities.Activity;
import com.sg.gksolution.project_management_system.services.ActivityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
        return activityService.getActivityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@Valid @RequestBody Activity activity) {
        Activity createdActivity = activityService.saveActivity(activity);
        return new ResponseEntity<>(createdActivity, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity updatedActivity) {
        return activityService.getActivityById(id)
                .map(existingActivity -> {
                    existingActivity.setName(updatedActivity.getName());
                    existingActivity.setDescription(updatedActivity.getDescription());
                    existingActivity.setStatus(updatedActivity.getStatus());
                    existingActivity.setStartDate(updatedActivity.getStartDate());
                    existingActivity.setEndDate(updatedActivity.getEndDate());
                    return ResponseEntity.ok(activityService.saveActivity(existingActivity));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


