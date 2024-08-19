package java.com.example.timesheetRest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private Long projectId;
    private Integer minutes;
    private LocalDate createdAt;

    public TimeSheet() {

    }

    public TimeSheet(Long id, Long projectId, Integer minutes, LocalDate createdAt) {
        this.id = id;
        this.projectId = projectId;
        this.minutes = minutes;
        this.createdAt = createdAt;
    }
}
