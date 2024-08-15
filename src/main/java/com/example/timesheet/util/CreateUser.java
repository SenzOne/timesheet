package com.example.timesheet.util;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    @PostConstruct
    public void createUsers() {
        Role role = Role.builder()
                .nameOfRole("Admin")
                .build();
    }
}
