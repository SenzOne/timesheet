package com.example.timesheet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Builder
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_of_role")
    private String nameOfRole;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Role() {
    }

    public Role(String name_of_role) {
        this.nameOfRole = name_of_role;
    }

    public Role(Long id, String name_of_role, Collection<User> users) {
        this.id = id;
        this.nameOfRole = name_of_role;
        this.users = users;
    }
}
