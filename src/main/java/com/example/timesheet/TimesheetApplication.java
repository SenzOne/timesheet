package com.example.timesheet;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.repository.TimesheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class TimesheetApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TimesheetApplication.class, args);
        TimesheetRepository timesheetRepository = ctx.getBean(TimesheetRepository.class);

        LocalDateTime localDateTime = LocalDateTime.now();
        for (int i = 0; i <10; i++) {
            LocalDate createdAt = LocalDate.from(localDateTime.plusDays(1));
            TimeSheet timeSheet = TimeSheet.builder()
                    .id((long) i)
                    .createdAt(createdAt)
                    .minutes(ThreadLocalRandom.current().nextInt(100, 1000))
                    .build();
            timesheetRepository.create(timeSheet);
        }
    }

}
