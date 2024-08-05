package com.example.timesheet.controller;

import lombok.Data;

@Data
public class TimeSheetPageDto {

    private String projectName;
    private String timeSheetId;
    private String minutes;
    private String timeSheetCreatedAt;
}
