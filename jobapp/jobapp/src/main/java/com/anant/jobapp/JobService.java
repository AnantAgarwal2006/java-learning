package com.anant.jobapp;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    public List<Job> getAllJobs() { 
        return List.of( 
            new Job(1, "Backend Developer Intern","Build REST APIs","Remote",15000),
            new Job(2,"Frontend Developer Intern","Build UI components","Bangalore",12000),
            new Job(3,"Full Stack Developer","Build comlpete features","Delhi",25000)
        );
    }
}
