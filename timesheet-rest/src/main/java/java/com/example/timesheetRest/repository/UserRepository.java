package java.com.example.timesheetRest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.com.example.timesheetRest.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
