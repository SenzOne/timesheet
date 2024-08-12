package com.example.timesheet.service;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.repository.ProjectRepository;
import com.example.timesheet.repository.TimeSheetRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService {

    private final TimeSheetRepository timesheetRepository;
    private final ProjectRepository projectRepository;

    public TimeSheetService(TimeSheetRepository timesheetRepository, ProjectRepository projectRepository) {
        this.timesheetRepository = timesheetRepository;
        this.projectRepository = projectRepository;
    }

    public Optional<TimeSheet> getById(Long id) {
        return timesheetRepository.findById(id);
    }

    public List<TimeSheet> getAll() {
        return timesheetRepository.findAll();
    }

    public Optional<TimeSheet> create(TimeSheet timeSheet) {

        if (projectRepository.findById(timeSheet.getProjectId()).isEmpty()) {
            return Optional.empty();
        }

        TimeSheet newTimeSheet = TimeSheet.builder()
                .createdAt(LocalDate.now())
                .minutes(timeSheet.getMinutes())
                .projectId(timeSheet.getProjectId())
                .build();

        return Optional.of(timesheetRepository.save(newTimeSheet));
    }

    public void delete(Long id) {
        timesheetRepository.deleteById(id);
    }
}
