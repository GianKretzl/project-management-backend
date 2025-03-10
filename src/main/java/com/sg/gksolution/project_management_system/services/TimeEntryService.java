package com.sg.gksolution.project_management_system.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.sg.gksolution.project_management_system.entities.TimeEntry;

public interface TimeEntryService {
    List<TimeEntry> getAllTimeEntries();
    Optional<TimeEntry> getTimeEntryById(Long id);
    TimeEntry saveTimeEntry(TimeEntry timeEntry);
    void deleteTimeEntryById(Long id);
    List<TimeEntry> getTimeEntriesByUserId(Long userId);
    List<TimeEntry> getTimeEntriesByPeriod(LocalDateTime start, LocalDateTime end);
}
