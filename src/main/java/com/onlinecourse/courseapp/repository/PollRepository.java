package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    // Custom query methods can be added here (e.g., findByCreatedBy)
}