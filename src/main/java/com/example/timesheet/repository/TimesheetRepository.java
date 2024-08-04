package com.example.timesheet.repository;

import com.example.timesheet.model.TimeSheet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TimesheetRepository {
    private static Long sequence = 1L;

    private final List<TimeSheet> timeSheets = new ArrayList<>();

    public Optional<TimeSheet> getById(Long id) {
        return timeSheets.stream().filter(timeSheet -> timeSheet.getId().equals(id)).findFirst();
    }

    public List<TimeSheet> getAll() {
        return timeSheets;
    }

    public TimeSheet create(TimeSheet timeSheet) {
        timeSheet.setId(sequence++);
        timeSheets.add(timeSheet);
        return timeSheet;
    }

    public void delete(Long id) {
        timeSheets.removeIf(timeSheet -> timeSheet.getId().equals(id));
    }
}
