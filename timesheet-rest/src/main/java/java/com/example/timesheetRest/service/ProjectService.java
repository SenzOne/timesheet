package java.com.example.timesheetRest.service;


import org.springframework.stereotype.Service;

import java.com.example.timesheetRest.model.Project;
import java.com.example.timesheetRest.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Optional<Optional<Project>> getById(Long id) {
        return Optional.of(projectRepository.findById(id));
    }

    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
