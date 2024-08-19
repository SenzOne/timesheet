package com.example.timesheet;

import com.example.timesheet.model.Project;
import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.repository.ProjectRepository;
import com.example.timesheet.repository.TimeSheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;
//
//@SpringBootApplication
//public class TimesheetApplication {
//
//    public static void main(String[] args) {
//        ApplicationContext ctx = SpringApplication.run(TimesheetApplication.class, args);
//        TimeSheetRepository timeSheetRepository = ctx.getBean(TimeSheetRepository.class);
//        ProjectRepository projectRepository = ctx.getBean(ProjectRepository.class);
//
//        for (int i = 1; i <= 5; i++) {
//            projectRepository.save(Project.builder()
//                    .id((long) i)
//                    .name("Project " + i)
//                    .build());
//        }
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        for (int i = 1; i <= 10; i++) {
//            LocalDate createdAt = LocalDate.from(localDateTime.plusDays(1));
//            TimeSheet timeSheet = TimeSheet.builder()
//                    .id((long) i)
//                    .createdAt(createdAt)
//                    .minutes(ThreadLocalRandom.current().nextInt(100, 1000))
//                    .projectId(ThreadLocalRandom.current().nextLong(1, 6))
//                    .build();
//            timeSheetRepository.save(timeSheet);
//        }
//    }
//}
