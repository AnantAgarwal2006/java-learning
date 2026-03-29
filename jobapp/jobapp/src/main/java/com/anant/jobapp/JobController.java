package com.anant.jobapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
// Tells Spring — "this class handles API requests and returns data"
public class JobController {

    @GetMapping("/jobs")
    // When someone sends a GET request to `/jobs` → run this method
    public List<String> getAllJobs() {
        return List.of( // Returns a simple list of job titles
            "Backend Developer Intern",
            "Frontend Developer Intern",
            "Full Stack Developer"
        );
    }
}