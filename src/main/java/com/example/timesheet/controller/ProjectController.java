package com.example.timesheet.controller;

import com.example.timesheet.model.Project;
import com.example.timesheet.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@Tag(name = "Projects", description = "Api для работы с проектами")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Get all Projects", description = "Получить список всех проектов")
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @Operation(summary = "Get Project by ID", description = "Получить проект по его идентификатору")
    @GetMapping("/projects/{id}")
    public ResponseEntity<Optional<Project>> getById(@PathVariable Long id) {
        return ResponseEntity.of(projectService.getById(id));
    }

    @Operation(summary = "Create Project", description = "Создать новый проект")
    @PostMapping("/projects")
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.create(project));
    }

    @Operation(summary = "Delete Project by ID", description = "Удалить проект по его идентификатору")
    @PostMapping("/projects/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}