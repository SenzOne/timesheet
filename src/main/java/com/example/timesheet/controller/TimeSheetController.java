package com.example.timesheet.controller;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.service.TimeSheetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "TimeSheets", description = "API для работы с табелями учета рабочего времени")
public class TimeSheetController {

    private final TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @Operation(summary = "Получить табель по ID", description = "Возвращает табель учета рабочего времени по заданному идентификатору")
    @GetMapping("/time-sheets/{id}")
    public ResponseEntity<TimeSheet> getById(@PathVariable Long id) {
        return ResponseEntity.of(timeSheetService.getById(id));
    }

    @Operation(summary = "Получить все табели", description = "Возвращает список всех табелей учета рабочего времени")
    @GetMapping("/time-sheets")
    public ResponseEntity<List<TimeSheet>> getAll() {
        return ResponseEntity.ok(timeSheetService.getAll());
    }

    @Operation(summary = "Создать новый табель", description = "Создает новый табель учета рабочего времени")
    @PostMapping("/time-sheets")
    public ResponseEntity<Optional<TimeSheet>> create(@RequestBody TimeSheet timeSheet) {
        if (timeSheet.getProjectId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(timeSheetService.create(timeSheet));
    }

    @Operation(summary = "Удалить табель по ID", description = "Удаляет табель учета рабочего времени по заданному идентификатору")
    @DeleteMapping("/time-sheets/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        timeSheetService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
