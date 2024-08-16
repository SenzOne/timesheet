package com.example.timesheet.repository;

import com.example.timesheet.model.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
}
