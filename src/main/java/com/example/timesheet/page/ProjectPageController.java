package com.example.timesheet.page;

import com.example.timesheet.model.Project;
import com.example.timesheet.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home/project-page")
public class ProjectPageController {


    private final ProjectService projectPageService;

    @GetMapping("/{id}")
    public String getProjectPage(@PathVariable Long id, Model model) {

        Project project = projectPageService.getById(id)
                .get()
                .orElseThrow(() -> new RuntimeException("Project not found"));

        model.addAttribute("project", project);

        return "project-page";
    }

}
