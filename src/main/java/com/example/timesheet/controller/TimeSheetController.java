package com.example.timesheet.controller;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.service.TimeSheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TimeSheetController {

    private final TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @GetMapping("/time-sheets/{id}")
    public ResponseEntity<TimeSheet> getById(@PathVariable Long id) {
        return ResponseEntity.of(timeSheetService.getById(id));
    }


    @GetMapping("/time-sheets")
    public ResponseEntity<List<TimeSheet>> getAll() {
        return ResponseEntity.ok(timeSheetService.getAll());
    }


    @PostMapping("/time-sheets")
    public ResponseEntity<Optional<TimeSheet>> create(TimeSheet timeSheet) {
        if (timeSheet.getProjectId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(timeSheetService.create(timeSheet));
    }

    @DeleteMapping("/time-sheets/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        timeSheetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
