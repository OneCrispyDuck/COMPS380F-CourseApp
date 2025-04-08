package com.onlinecourse.courseapp.repository;

import com.onlinecourse.courseapp.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    // You can define custom queries here if needed in the future
}