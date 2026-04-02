package com.anant.jobapp;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


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
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
        // {id} is a path variable -> it is a placeholder 
        // when someone visits /job/1 -> id becomes 1 
        // when someone visits /job/2 -> id becomes 2
        // When someone sends a GET request to `/jobs` → run this method
        // public List<String> getAllJobs() {  { 
        //return List.of( // Returns a simple list of job titles
        //     "Backend Developer Intern",
        //     "Frontend Developer Intern",
        //     "Full Stack Developer"
        //     // this is a fake data ,in real world ,job has many details ->titile,description,location,salary etc.
        // );
        // now the method returnning the real objects now

        // public List<Job> getAllJobs() { 
        //       jobService.getAllJobs();return 
        // }
    
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Integer id){
        // @PathVariable int id
        // this tells Spring:take the {id}fom the URL  and give it to this method as "id".
        return jobService.getJobById(id);
    }

    @PostMapping("/jobs")
    public String addJob(@RequestBody Job job){

        jobService.addJob(job);
        return "Job added successfully";
    }
    // When someone sends DELETE request to /jobs/1 run this method
    // if deleted then service returned true else job not found.
    @DeleteMapping("/jobs/{id}")
    public String deleteJob(@PathVariable Integer id){
        boolean deleted=jobService.deleteJob(id);
        if(deleted){
            return "Job deleted successfully";
        }
        return"Job not found";
    }
    @PutMapping("/jobs/{id}")
    // when someone sends PUT request to /jobs/1 run this method.
    public Job updateJob(@PathVariable Integer id ,@RequestBody Job updatedJob){
        //@RequestBody Job updatedJob : new job data comes in request body as JSON
        return jobService.updateJob(id, updatedJob);
    }
    // returns the updated job -> good practise-> return what was saved so caller can verify.
}
/* 
**`@PostMapping("/jobs")`**
→ When someone sends a POST request to `/jobs` → run this method

**`@RequestBody Job job`**
→ The request will contain job data in JSON format
→ `@RequestBody` tells Spring: "take the JSON from request body and convert it into a `Job` object automatically"

So the flow is:
```
Someone sends POST /jobs with job data in JSON
↓
Spring converts JSON → Job object
↓
addJob() saves it to list
↓
Returns "Job added successfully" */