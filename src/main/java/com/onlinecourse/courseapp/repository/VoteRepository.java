package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.Poll;
import com.onlinecourse.courseapp.model.User;
import com.onlinecourse.courseapp.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findByUserAndPoll(User user, Poll poll);
}

/*
This repository provides CRUD operations for the Vote entity and
includes a custom method to check if a user has already voted in a poll, which is used in PollController.java
 */