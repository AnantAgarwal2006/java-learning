package com.anant.jobapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.swing.Spring;

@RestController
// Tells Spring — "this class handles API requests and returns data"

public class JobController {

    private JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }
    //     Instead Spring automatically creates `JobService` and passes it to your controller. This is called **Dependency Injection.**

        // Think of it like:
    // > "I need a JobService. Spring, please give me one."

    // Spring handles the creation. You just use it.

    @GetMapping("/jobs")
        // When someone sends a GET request to `/jobs` → run this method
        // public List<String> getAllJobs() {  { 
        //return List.of( // Returns a simple list of job titles
        //     "Backend Developer Intern",
        //     "Frontend Developer Intern",
        //     "Full Stack Developer"
        //     // this is a fake data ,in real world ,job has many details ->titile,description,location,salary etc.
        // );
        // now the method returnning the real objects now

    public List<Job> getAllJobs() { 
        return jobService.getAllJobs();
    }
}