package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.PollOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollOptionRepository extends JpaRepository<PollOption, Long> {
    // You could add: List<PollOption> findByPollId(Long pollId);
}