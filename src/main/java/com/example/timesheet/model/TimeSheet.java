package com.example.timesheet.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TimeSheet {

    private Long id;
    private Long projectId;
    private Integer minutes;
    private LocalDate createdAt;
}
