package com.example.timesheet.service;

import com.example.timesheet.client.ProjectResponse;
import com.example.timesheet.client.TimesheetResponse;
import com.example.timesheet.page.TimeSheetPageDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService {

    private final RestClient restClient;

    public TimesheetService() {
        this.restClient = RestClient.create("http://localhost:8081");
    }


    public Optional<TimeSheetPageDto> getById(Long id) {
        try {
            TimesheetResponse timesheetResponse = restClient.get()
                    .uri("/time-sheets/" + id)
                    .retrieve()
                    .body(TimesheetResponse.class);

            TimeSheetPageDto timeSheetPageDto = new TimeSheetPageDto();
            timeSheetPageDto.setTimeSheetId(String.valueOf(timesheetResponse.getId()));
            timeSheetPageDto.setMinutes(String.valueOf(timesheetResponse.getMinutes()));
            timeSheetPageDto.setTimeSheetCreatedAt(timesheetResponse.getTimeSheetCreatedAt());
            timeSheetPageDto.setProjectId(String.valueOf(timesheetResponse.getProjectId()));

            ProjectResponse project = restClient.get()
                    .uri("/projects/" + timesheetResponse.getProjectId())
                    .retrieve()
                    .body(ProjectResponse.class);
            return Optional.of(timeSheetPageDto);

        } catch (HttpClientErrorException.NotFound e) {
            return Optional.empty();
        }
    }

    public List<TimeSheetPageDto> getAll() {
        List<TimesheetResponse> timesheetResponses = restClient.get()
                .uri("/time-sheets")
                .retrieve()
                .body(new ParameterizedTypeReference<List<TimesheetResponse>>() {

                });

        List<TimeSheetPageDto> result = new ArrayList<>();
        for (TimesheetResponse timesheetResponse : timesheetResponses) {
            TimeSheetPageDto timeSheetPageDto = new TimeSheetPageDto();
            timeSheetPageDto.setTimeSheetId(String.valueOf(timesheetResponse.getId()));
            timeSheetPageDto.setMinutes(String.valueOf(timesheetResponse.getMinutes()));
            //TODO: поченить setTimeSheetCreatedAt
//            timeSheetPageDto.setTimeSheetCreatedAt(timesheetResponse.getTimeSheetCreatedAt().toString());
            timeSheetPageDto.setProjectId(String.valueOf(timesheetResponse.getProjectId()));

            ProjectResponse project = restClient.get()
                    .uri("/projects/" + timesheetResponse.getProjectId())
                    .retrieve()
                    .body(ProjectResponse.class);

            timeSheetPageDto.setProjectName(project.getName());
            result.add(timeSheetPageDto);
        }
        return result;
    }

//    public Optional<TimeSheet> create(TimeSheet timeSheet) {
//
//        if (projectRepository.findById(timeSheet.getProjectId()).isEmpty()) {
//            return Optional.empty();
//        }
//
//        TimeSheet newTimeSheet = TimeSheet.builder()
//                .createdAt(LocalDate.now())
//                .minutes(timeSheet.getMinutes())
//                .projectId(timeSheet.getProjectId())
//                .build();
//
//        return Optional.of(timesheetRepository.save(newTimeSheet));
//    }
//
//    public void delete(Long id) {
//        timesheetRepository.deleteById(id);
//    }
}
