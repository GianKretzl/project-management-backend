package com.sg.gksolution.project_management_system.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gksolution.project_management_system.entities.TimeEntry;
import com.sg.gksolution.project_management_system.services.TimeEntryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryService timeEntryService;

    public TimeEntryController(TimeEntryService timeEntryService) {
        this.timeEntryService = timeEntryService;
    }

    @GetMapping
    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryService.getAllTimeEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> getTimeEntryById(@PathVariable Long id) {
        return timeEntryService.getTimeEntryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TimeEntry> createTimeEntry(@Valid @RequestBody TimeEntry timeEntry) {
        TimeEntry createdTimeEntry = timeEntryService.saveTimeEntry(timeEntry);
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntry> updateTimeEntry(@PathVariable Long id, @RequestBody TimeEntry updatedTimeEntry) {
        return timeEntryService.getTimeEntryById(id)
                .map(existingTimeEntry -> {
                    existingTimeEntry.setDescription(updatedTimeEntry.getDescription());
                    existingTimeEntry.setStartTime(updatedTimeEntry.getStartTime());
                    existingTimeEntry.setEndTime(updatedTimeEntry.getEndTime());
                    return ResponseEntity.ok(timeEntryService.saveTimeEntry(existingTimeEntry));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeEntryById(@PathVariable Long id) {
        if (timeEntryService.getTimeEntryById(id).isPresent()) {
            timeEntryService.deleteTimeEntryById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
