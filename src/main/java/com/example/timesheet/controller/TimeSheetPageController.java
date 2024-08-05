package com.example.timesheet.controller;

import com.example.timesheet.model.TimeSheet;
import com.example.timesheet.service.TimeSheetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/home/time-sheets")
public class TimeSheetPageController {

    private final TimeSheetService timeSheetService;

    public TimeSheetPageController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }

    @GetMapping("/{id}")
    public String getTimeSheetPage(@PathVariable Long id, Model model) {
        Optional<TimeSheet> timeSheetOptional = timeSheetService.getById(id);

        if (timeSheetOptional.isEmpty())
            throw new RuntimeException("TimeSheet not found");

        TimeSheet timeSheet = timeSheetOptional.get();

        model.addAttribute("timeSheet", timeSheet);
        model.addAttribute("timeSheetId", id);
        model.addAttribute("timeSheetMinutes", timeSheet.getMinutes());
        model.addAttribute("timeSheetCreatedAt", timeSheet.getCreatedAt().toString());

        return "time-sheets";
    }
}
