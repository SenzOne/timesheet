package java.com.example.timesheetRest.util;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.com.example.timesheetRest.model.Role;
import java.com.example.timesheetRest.model.User;
import java.com.example.timesheetRest.repository.RoleRepository;
import java.com.example.timesheetRest.repository.UserRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateUser {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void createUsers() {

        Role roleAdmin = new Role("Admin");
        Role roleUser = new Role("User");
        List<Role> roles = Arrays.asList(roleAdmin, roleUser);
        roleRepository.saveAll(roles);

        List<User> users = Arrays.asList(
                new User(1L, "admin", passwordEncoder.encode("admin"), Set.of(roleAdmin)),
                new User(2L, "user", passwordEncoder.encode("user"), Set.of(roleUser))
        );
        User admin = users.get(0);
        User user = users.get(1);
        admin.setRoles(Set.of(roleAdmin));
        user.setRoles(Set.of(roleUser));

        userRepository.save(admin);
        userRepository.save(user);
    }
}
