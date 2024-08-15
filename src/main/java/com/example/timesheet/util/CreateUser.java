package com.example.timesheet.util;

import com.example.timesheet.model.Role;
import com.example.timesheet.model.User;
import com.example.timesheet.repository.RoleRepository;
import com.example.timesheet.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    public void createUsers() {

        Role roleAdmin = new Role(1L, "Role_Admin");
        Role roleUser = new Role(2L, "Role_User");
        List<Role> roles = Arrays.asList(roleAdmin, roleUser);
        roleRepository.saveAll(roles);

        List<User> users = Arrays.asList(
                new User(1L, "admin", "admin", List.of(roleAdmin)),
                new User(2L, "user", "user", List.of(roleUser))
        );
        User admin = users.get(0);
        User user = users.get(1);
        admin.setRoles(List.of(roleAdmin));
        user.setRoles(List.of(roleUser));

        userRepository.save(admin);
        userRepository.save(user);
    }
}
