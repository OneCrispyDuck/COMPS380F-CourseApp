package com.onlinecourse.courseapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@RestController
public class UploadController {

    // Inject external upload directory from application.properties
    @Value("${upload.dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(uploadDir, file.getOriginalFilename());
            Files.copy(file.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            return "✅ File uploaded to: " + uploadPath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "❌ File upload failed: " + e.getMessage();
        }
    }
}