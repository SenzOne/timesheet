package com.example.timesheet.page;

import com.example.timesheet.service.TimesheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home/time-sheets")
public class TimeSheetPageController {

    private final TimesheetService timesheetService;

    @GetMapping("/{id}")
    public String getTimeSheetPage(@PathVariable Long id, Model model) {

        Optional<TimeSheetPageDto> timeSheetPageDto = timesheetService.getById(id);
        if (timeSheetPageDto.isEmpty()) {
           return "redirect: /not-found";
        }
        model.addAttribute("timeSheets", timeSheetPageDto.get());

        return "time-sheets";
    }

    @GetMapping
    public String getAllTimeSheets(Model model) {
        model.addAttribute("timeSheets", timesheetService.getAll());
        return "time-sheets-page";
    }
}
