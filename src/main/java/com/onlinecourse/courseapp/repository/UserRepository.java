package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

/*
This aligns with Spring Data JPA conventions for dynamic query methods
 */