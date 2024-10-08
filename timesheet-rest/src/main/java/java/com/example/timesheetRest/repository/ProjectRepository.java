package java.com.example.timesheetRest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.com.example.timesheetRest.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
