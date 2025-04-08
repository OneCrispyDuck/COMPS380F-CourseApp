package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}