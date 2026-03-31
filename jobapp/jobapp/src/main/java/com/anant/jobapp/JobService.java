package com.anant.jobapp;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

//private List<Job> jobs = new ArrayList<>(); // real list, can add/remove
@Service
public class JobService {
    private List<Job> jobs=new ArrayList<>();
    // public List<Job> getAllJobs() { 
    //     return List.of(  // return List.of(...) // fixed list, cannot add to it
    public JobService(){
            jobs.add(new Job(1, "Backend Developer Intern","Build REST APIs","Remote",15000));
            jobs.add(new Job(2,"Frontend Developer Intern","Build UI components","Bangalore",12000));
            jobs.add(new Job(3,"Full Stack Developer","Build comlpete features","Delhi",25000));
    }
    
    public List<Job> getAllJobs() {
        return jobs;
    }
    public  Job getJobById(int id){
        // List<Job>jobs=getAllJobs();   // first get all jobs 
        for(Job job:jobs){  // this is called for each loop -> it goes through every job in the list one by one -> each time , current job is stored in job variable .
            if(job.getId()==id){  //check if this job's id matches what was requested -> if yes then return that job.
                return job;
            }
        }
        return null;   // if not job foind with theat id-> return nothing-> we will handle this better later with proper error handling .
    }
    public void addJob(Job job){
        jobs.add(job);
    }
}
