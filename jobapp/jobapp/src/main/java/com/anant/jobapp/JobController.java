package com.anant.jobapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
// Tells Spring — "this class handles API requests and returns data"
public class JobController {

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
        return List.of( 
            new Job(1, "Backend Developer Intern","Build REST APIs","Remote",15000),
            new Job(2,"Frontend Developer Intern","Build UI components","Bangalore",12000),
            new Job(3,"Full Stack Developer","Build comlpete features","Delhi",25000)
        );
    }
}