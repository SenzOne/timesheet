package com.example.timesheet.page;

import lombok.Data;

@Data
public class TimeSheetPageDto {

    private String projectName;
    private String timeSheetId;
    private String minutes;
    private String timeSheetCreatedAt;
    private String projectId;
}
