package java.com.example.timesheetRest.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.com.example.timesheetRest.model.Project;
import java.com.example.timesheetRest.service.ProjectService;
import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("/projects{id}")
    public ResponseEntity<Optional<Project>> getById(@PathVariable Long id) {
        return ResponseEntity.of(projectService.getById(id));
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> create(Project project) {
        return ResponseEntity.ok(projectService.create(project));
    }

    @PostMapping("/projects/{id}")
    public ResponseEntity<Project> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
