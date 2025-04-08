package com.onlinecourse.courseapp.controller;

import com.onlinecourse.courseapp.model.User;
import com.onlinecourse.courseapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ Constructor injection (cleaner and testable)
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // resolved to /WEB-INF/jsp/login.jsp [[4]](https://poe.com/citation?message_id=373981943480&citation=4)
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // resolved to /WEB-INF/jsp/register.jsp [[4]](https://poe.com/citation?message_id=373981943480&citation=4)
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String rawPassword) {

        if (userRepository.existsById(username)) {
            return "redirect:/register?error";
        }

        // Save hashed password
        User user = new User(username, passwordEncoder.encode(rawPassword));
        userRepository.save(user);

        return "redirect:/register?success";
    }
}