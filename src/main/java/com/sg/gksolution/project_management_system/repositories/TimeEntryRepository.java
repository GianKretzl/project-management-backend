package com.sg.gksolution.project_management_system.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sg.gksolution.project_management_system.entities.TimeEntry;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Long> {
    List<TimeEntry> findByUserId(Long userId);
    List<TimeEntry> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);
}

