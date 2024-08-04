package com.example.timesheet.service;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.repository.TimesheetRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeSheetService {

    private final TimesheetRepository timesheetRepository;

    public TimeSheetService(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    public Optional<TimeSheet> getById(Long id) {
        return timesheetRepository.getById(id);
    }

    public List<TimeSheet> getAll() {
        return timesheetRepository.getAll();
    }

    public TimeSheet create(TimeSheet timeSheet) {
        return timesheetRepository.create(timeSheet);
    }

    public void delete(Long id) {
        timesheetRepository.delete(id);
    }
}
