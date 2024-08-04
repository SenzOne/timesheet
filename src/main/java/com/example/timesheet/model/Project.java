package com.example.timesheet.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Project {

    private Long id;
    private String name;
}
