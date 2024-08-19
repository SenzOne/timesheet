package java.com.example.timesheetRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository<Role> extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r JOIN r.users u WHERE u.id = :userId")
    List<Role> findUserRolesByUsersId(@Param("userId") Long userId);
}
