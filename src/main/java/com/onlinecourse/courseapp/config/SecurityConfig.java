package com.onlinecourse.courseapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/resources/**", "/register", "/login").permitAll()
                        .requestMatchers("/lectures/upload").hasRole("TEACHER")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                );

        return http.build();
    }
}


/*
@EnableWebSecurity	✅	Required to enable Spring Security configuration.
UserDetailsService via UserRepository	✅	Properly loads user by username and maps to Spring Security User object.
PasswordEncoder (BCrypt)	✅	Secure choice for password hashing.
formLogin() and logout() config	✅	Custom login/logout pages, with CSRF enabled.
Role-based restriction (hasRole("TEACHER"))	✅	Ensures only teachers can access /lectures/upload.
 */