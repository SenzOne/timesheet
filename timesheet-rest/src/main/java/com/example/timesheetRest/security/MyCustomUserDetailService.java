//package com.example.timesheetRest.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import com.example.timesheetRest.model.Role;
//import com.example.timesheetRest.repository.RoleRepository;
//import com.example.timesheetRest.repository.UserRepository;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class MyCustomUserDetailService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//    private final RoleRepository roleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        com.example.timesheetRest.model.User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        List<Role> userRolesByUserId = roleRepository.findUserRolesByUsersId(user.getId());
//        return new User(user.getUsername(),
//                user.getPassword(),
//                userRolesByUserId.stream()
//                        .map(it -> new SimpleGrantedAuthority(it.getNameOfRole()))
//                        .toList());
//    }
//}
