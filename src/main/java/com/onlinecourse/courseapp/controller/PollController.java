package com.onlinecourse.courseapp.controller;

import com.onlinecourse.courseapp.model.Poll;
import com.onlinecourse.courseapp.model.PollOption;
import com.onlinecourse.courseapp.model.User;
import com.onlinecourse.courseapp.model.Vote;
import com.onlinecourse.courseapp.repository.PollOptionRepository;
import com.onlinecourse.courseapp.repository.PollRepository;
import com.onlinecourse.courseapp.repository.UserRepository;
import com.onlinecourse.courseapp.repository.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private PollOptionRepository pollOptionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VoteRepository voteRepository;

    // 1. List all polls
    @GetMapping
    public String listPolls(ModelMap model) {
        List<Poll> polls = pollRepository.findAll();
        model.addAttribute("polls", polls);
        return "polls/list"; // maps to /WEB-INF/jsp/polls/list.jsp
    }

    // 2. Show poll detail
    @GetMapping("/{id}")
    public String viewPoll(@PathVariable Long id, ModelMap model) {
        Poll poll = pollRepository.findById(id).orElse(null);
        if (poll == null) {
            return "redirect:/polls";
        }
        model.addAttribute("poll", poll);
        return "polls/detail"; // maps to /WEB-INF/jsp/polls/detail.jsp
    }

    // 3. Show poll creation form (GET)
    @GetMapping("/create")
    public String showCreateForm(ModelMap model) {
        model.addAttribute("poll", new Poll());
        return "polls/create"; // maps to /WEB-INF/jsp/polls/create.jsp
    }

    // 4. Handle poll creation (POST)
    @PostMapping("/create")
    public String submitPoll(@RequestParam String question,
                             @RequestParam List<String> options,
                             Principal principal) {

        String username = principal.getName();
        User currentUser = userRepository.findById(username).orElse(null);

        if (currentUser == null) {
            return "redirect:/polls/create";
        }

        Poll poll = new Poll();
        poll.setQuestion(question);
        poll.setCreatedAt(LocalDateTime.now());
        poll.setCreatedBy(currentUser);

        poll = pollRepository.save(poll);

        for (String optionText : options) {
            PollOption option = new PollOption();
            option.setText(optionText);
            option.setPoll(poll);
            pollOptionRepository.save(option);
        }

        return "redirect:/polls";
    }

    // 5. Show voting form
    @GetMapping("/{id}/vote")
    public String showVoteForm(@PathVariable Long id, ModelMap model) {
        Poll poll = pollRepository.findById(id).orElse(null);
        if (poll == null) {
            return "redirect:/polls";
        }
        model.addAttribute("poll", poll);
        return "polls/vote"; // maps to /WEB-INF/jsp/polls/vote.jsp
    }

    // 6. Handle vote submission
    @PostMapping("/{id}/vote")
    public String submitVote(@PathVariable Long id,
                             @RequestParam Long selectedOptionId,
                             Principal principal) {

        Poll poll = pollRepository.findById(id).orElse(null);
        if (poll == null) {
            return "redirect:/polls";
        }

        User user = userRepository.findById(principal.getName()).orElse(null);
        if (user == null) {
            return "redirect:/polls";
        }

        // Check if user already voted in this poll
        if (voteRepository.findByUserAndPoll(user, poll).isPresent()) {
            return "redirect:/polls/" + id + "?error=already_voted";
        }

        PollOption selectedOption = pollOptionRepository.findById(selectedOptionId).orElse(null);
        if (selectedOption == null) {
            return "redirect:/polls/" + id;
        }

        Vote vote = new Vote();
        vote.setUser(user);
        vote.setPoll(poll);
        vote.setSelectedOption(selectedOption);
        vote.setVotedAt(LocalDateTime.now());

        voteRepository.save(vote);

        return "redirect:/polls/" + id + "?success=voted";
    }
}