//package com.example.timesheetRest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.core.GrantedAuthorityDefaults;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
//public class SecurityConfig {
//
//    @Bean
//    GrantedAuthorityDefaults grantedAuthorityDefaults() {
//        return new GrantedAuthorityDefaults("");
//    }
//
////    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/time-sheets/**").hasAnyRole("admin", "user") // user может просматривать только свои записи
//                        .requestMatchers("/projects/**").hasRole("admin") // админ может смотреть все
//
//                                .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
