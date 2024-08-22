package com.example.timesheetRest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.timesheetRest.model.TimeSheet;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
}
