package com.example.timesheet.service;

import com.example.timesheet.page.TimeSheetPageDto;
import com.example.timesheet.model.Project;
import com.example.timesheet.model.TimeSheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeSheetPageService {

    private final TimeSheetService timeSheetService;
    private final ProjectService projectService;

    public Optional<TimeSheetPageDto> findById(Long id) {

        return timeSheetService.getById(id)
                .map(this::convert);
    }

    private TimeSheetPageDto convert(TimeSheet timeSheet) {
        Project project = (projectService.getById(timeSheet.getProjectId())
                .get().orElseThrow(() -> new RuntimeException("Project not found")));

        TimeSheetPageDto timeSheetPageDto = new TimeSheetPageDto();
        timeSheetPageDto.setTimeSheetId(String.valueOf(timeSheet.getId()));
        timeSheetPageDto.setProjectName(project.getName());
        timeSheetPageDto.setProjectId(String.valueOf(project.getId()));
        timeSheetPageDto.setMinutes(String.valueOf(timeSheet.getMinutes()));
        timeSheetPageDto.setTimeSheetCreatedAt(timeSheet.getCreatedAt().toString());

        return timeSheetPageDto;
    }

    public List<TimeSheetPageDto> findAll() {

        return timeSheetService.getAll().stream()
                .map(this::convert)
                .toList();
    }
}
