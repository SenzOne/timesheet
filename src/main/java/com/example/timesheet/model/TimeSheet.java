package com.example.timesheet.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TimeSheet {

    private Long id;
    private String project;
    private Integer minutes;
    private LocalDate createdAt;
}
