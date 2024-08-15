package com.example.timesheet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfRole;

    public Role() {
    }

    public Role(Long id, String nameOfRole) {
        this.id = id;
        this.nameOfRole = nameOfRole;
    }
}
