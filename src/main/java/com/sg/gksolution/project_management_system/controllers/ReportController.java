package com.sg.gksolution.project_management_system.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.gksolution.project_management_system.entities.Activity;
import com.sg.gksolution.project_management_system.entities.TimeEntry;
import com.sg.gksolution.project_management_system.services.ActivityService;
import com.sg.gksolution.project_management_system.services.TimeEntryService;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ActivityService activityService;
    private final TimeEntryService timeEntryService;

    public ReportController(ActivityService activityService, TimeEntryService timeEntryService) {
        this.activityService = activityService;
        this.timeEntryService = timeEntryService;
    }

    // Relatório por Projeto
    @GetMapping("/activities-by-project/{projectId}")
    public List<Activity> getActivitiesByProject(@PathVariable Long projectId) {
        // Este filtro será implementado no serviço
        return activityService.getActivitiesByProjectId(projectId);
    }

    // Relatório de Lançamentos de Horas por Usuário
    @GetMapping("/time-entries-by-user/{userId}")
    public List<TimeEntry> getTimeEntriesByUser(@PathVariable Long userId) {
        // Este filtro será implementado no serviço
        return timeEntryService.getTimeEntriesByUserId(userId);
    }

    // Relatório de Lançamentos de Horas por Período
    @GetMapping("/time-entries-by-period")
    public List<TimeEntry> getTimeEntriesByPeriod(
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        // Este filtro será implementado no serviço
        return timeEntryService.getTimeEntriesByPeriod(start, end);
    }
}
