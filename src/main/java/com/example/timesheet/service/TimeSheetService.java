package com.example.timesheet.service;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.repository.ProjectRepository;
import com.example.timesheet.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService {

    private final TimesheetRepository timesheetRepository;
    private final ProjectRepository projectRepository;

    public TimeSheetService(TimesheetRepository timesheetRepository, ProjectRepository projectRepository) {
        this.timesheetRepository = timesheetRepository;
        this.projectRepository = projectRepository;
    }

    public Optional<TimeSheet> getById(Long id) {
        return timesheetRepository.getById(id);
    }

    public List<TimeSheet> getAll() {
        return timesheetRepository.getAll();
    }

    public Optional<TimeSheet> create(TimeSheet timeSheet) {

        if (projectRepository.getById(timeSheet.getProjectId()).isEmpty()) {
            return Optional.empty();
        }

        TimeSheet newTimeSheet = TimeSheet.builder()
                .createdAt(LocalDate.now())
                .minutes(timeSheet.getMinutes())
                .projectId(timeSheet.getProjectId())
                .build();

        return Optional.of(timesheetRepository.create(newTimeSheet));
    }

    public void delete(Long id) {
        timesheetRepository.delete(id);
    }
}
