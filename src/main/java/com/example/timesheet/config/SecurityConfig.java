package com.example.timesheet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(requests -> requests
//          .requestMatchers("/home/projects/**").hasAuthority(Role.ADMIN.getName())
//        .requestMatchers("/home/projects/**").hasRole("admin") // MY_ROLE_PREFIX_admin
//                                .requestMatchers("/home/time-sheets/**").hasAnyAuthority(Role.USER.getName())
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
                .build();
    }
}
