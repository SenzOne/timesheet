package com.example.timesheetRest.util;


import com.example.timesheetRest.model.Role;
import com.example.timesheetRest.model.User;
import com.example.timesheetRest.repository.RoleRepository;
import com.example.timesheetRest.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
//    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createUsers() {

        Role roleAdmin = new Role("Admin");
        Role roleUser = new Role("User");
        List<Role> roles = Arrays.asList(roleAdmin, roleUser);
        roleRepository.saveAll(roles);

        List<User> users = Arrays.asList(
                new User(1L, "admin", "admin", Set.of(roleAdmin)),
                new User(2L, "user","user", Set.of(roleUser))
        );
        User admin = users.get(0);
        User user = users.get(1);
        admin.setRoles(Set.of(roleAdmin));
        user.setRoles(Set.of(roleUser));

        userRepository.save(admin);
        userRepository.save(user);
    }
}
