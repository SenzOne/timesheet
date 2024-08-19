package java.com.example.timesheetRest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import java.com.example.timesheetRest.model.TimeSheet;

public interface TimeSheetRepository extends JpaRepository<TimeSheet, Long> {
}
