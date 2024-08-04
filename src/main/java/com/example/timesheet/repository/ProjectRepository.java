package com.example.timesheet.repository;

import com.example.timesheet.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {
    private static Long sequence = 1L;

    private final List<Project> timeSheets = new ArrayList<>();


    public Optional<Project> getById(Long id) {
        return timeSheets.stream().filter(timeSheet -> timeSheet.getId().equals(id)).findFirst();
    }

    public List<Project> getAll() {
        return timeSheets;
    }

    public Project create(Project project) {
        project.setId(sequence++);
        timeSheets.add(project);
        return project;
    }

    public void delete(Long id) {
        timeSheets.removeIf(project -> project.getId().equals(id));
    }
}
