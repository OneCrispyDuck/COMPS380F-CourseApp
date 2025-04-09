package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.Comment;
import com.onlinecourse.courseapp.model.Poll;
import com.onlinecourse.courseapp.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPoll(Poll poll);
    List<Comment> findByLecture(Lecture lecture);
}

/*
This allows fetching all comments for a specific poll or lecture
 */