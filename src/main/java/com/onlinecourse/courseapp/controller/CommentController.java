package com.onlinecourse.courseapp.controller;

import com.onlinecourse.courseapp.model.*;
import com.onlinecourse.courseapp.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.security.Principal;

@Controller
@RequestMapping("/comments")
public class CommentController {

    @Autowired private CommentRepository commentRepo;
    @Autowired private UserRepository userRepo;
    @Autowired private PollRepository pollRepo;
    @Autowired private LectureRepository lectureRepo;

    @PostMapping("/add")
    public String addComment(@RequestParam String text,
                             @RequestParam(required = false) Long pollId,
                             @RequestParam(required = false) Long lectureId,
                             Principal principal) {

        if (principal == null) return "redirect:/login";

        User author = userRepo.findByUsername(principal.getName()).orElse(null);
        if (author == null) return "redirect:/login";

        Comment comment = new Comment();
        comment.setText(text);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setAuthor(author);

        String redirectUrl = "/";

        if (pollId != null) {
            Poll poll = pollRepo.findById(pollId).orElse(null);
            if (poll != null) {
                comment.setPoll(poll);
                redirectUrl = "/polls/" + poll.getId();
            }
        }

        if (lectureId != null) {
            Lecture lecture = lectureRepo.findById(lectureId).orElse(null);
            if (lecture != null) {
                comment.setLecture(lecture);
                redirectUrl = "/lectures/" + lecture.getId();
            }
        }

        commentRepo.save(comment);
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, ModelMap model) {
        Comment comment = commentRepo.findById(id).orElse(null);
        if (comment == null) {
            return "redirect:/";
        }
        model.addAttribute("comment", comment);
        return "EditComment"; // /WEB-INF/jsp/EditComment.jsp
    }

    @PostMapping("/edit/{id}")
    public String saveEdit(@PathVariable Long id, @RequestParam String text) {
        Comment comment = commentRepo.findById(id).orElse(null);
        if (comment != null) {
            comment.setText(text);
            comment.setCreatedAt(LocalDateTime.now());
            commentRepo.save(comment);
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Comment comment = commentRepo.findById(id).orElse(null);
        String redirectUrl = "/";
        if (comment != null) {
            if (comment.getPoll() != null) {
                redirectUrl = "/polls/" + comment.getPoll().getId();
            } else if (comment.getLecture() != null) {
                redirectUrl = "/lectures/" + comment.getLecture().getId();
            }
            commentRepo.deleteById(id);
        }
        return "redirect:" + redirectUrl;
    }
}