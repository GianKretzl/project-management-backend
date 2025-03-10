package com.sg.gksolution.project_management_system.services.impl;

import com.sg.gksolution.project_management_system.entities.TimeEntry;
import com.sg.gksolution.project_management_system.repositories.TimeEntryRepository;
import com.sg.gksolution.project_management_system.services.TimeEntryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TimeEntryServiceImpl implements TimeEntryService {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryServiceImpl(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @Override
    public List<TimeEntry> getAllTimeEntries() {
        return timeEntryRepository.findAll();
    }

    @Override
    public Optional<TimeEntry> getTimeEntryById(Long id) {
        return timeEntryRepository.findById(id);
    }

    @Override
    public TimeEntry saveTimeEntry(TimeEntry timeEntry) {
        return timeEntryRepository.save(timeEntry);
    }

    @Override
    public void deleteTimeEntryById(Long id) {
        timeEntryRepository.deleteById(id);
    }

    @Override
    public List<TimeEntry> getTimeEntriesByUserId(Long userId) {
        return timeEntryRepository.findByUserId(userId);
    }

    @Override
    public List<TimeEntry> getTimeEntriesByPeriod(LocalDateTime start, LocalDateTime end) {
        return timeEntryRepository.findByStartTimeBetween(start, end);
    }
}
