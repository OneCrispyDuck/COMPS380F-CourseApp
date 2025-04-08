package com.onlinecourse.courseapp.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "poll_id")
    private Poll poll;

    @ManyToOne
    @JoinColumn(name = "selected_option_id")
    private PollOption selectedOption;

    private LocalDateTime votedAt;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Poll getPoll() {
        return poll;
    }

    public void setPoll(Poll poll) {
        this.poll = poll;
    }

    public PollOption getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(PollOption selectedOption) {
        this.selectedOption = selectedOption;
    }

    public LocalDateTime getVotedAt() {
        return votedAt;
    }

    public void setVotedAt(LocalDateTime votedAt) {
        this.votedAt = votedAt;
    }
}

/*
This entity represents a vote cast by a user for a specific option in a poll.
It maps the relationships using @ManyToOne annotations, which are typical for Spring Data JPA entities.
 */

