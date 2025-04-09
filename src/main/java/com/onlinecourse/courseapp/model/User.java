package com.onlinecourse.courseapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String username;

    private String password;

    private String role; // STUDENT or TEACHER

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Constructors
    public User() {}

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

/*
Why This Update Is Required:
Your SecurityConfig.java file is using .roles(user.getRole()) to assign roles to authenticated users, which requires the getRole() method to be present in the User entity.
This allows Spring Security to enforce access controls like .hasRole("TEACHER") for uploading lectures.
It also aligns with the default users table structure expected when integrating with JDBC-based authentication.
 */