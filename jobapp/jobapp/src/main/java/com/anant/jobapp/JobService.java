package com.anant.jobapp;
import org.springframework.stereotype.Service;
// import java.util.ArrayList;  remove this now as we a using the database to store the data .
import java.util.List;

//private List<Job> jobs = new ArrayList<>(); // real list, can add/remove
@Service
public class JobService {
    private JobRepository jobRepository;
    // private List<Job> jobs=new ArrayList<>();// right now we have our all data in this line . 
    // this is ram memory temporary storage . 
    // but what if two users apply to same job, data will not shared properly .
    // once the server is closed all data gone
    // what if 1 million jobs are there then the ram runs out .
    // this problem is sloved by database in which:
    //1) data is permanent on disk.
    //2)everyone can access same data .
    //3)handles millions of records efficiently.
    // public List<Job> getAllJobs() { 
    //     return List.of(  // return List.of(...) // fixed list, cannot add to it
    public JobService(JobRepository jobRepository){
    //         jobs.add(new Job(1, "Backend Developer Intern","Build REST APIs","Remote",15000));
    //         jobs.add(new Job(2,"Frontend Developer Intern","Build UI components","Bangalore",12000));
    //         jobs.add(new Job(3,"Full Stack Developer","Build comlpete features","Delhi",25000));
        this.jobRepository=jobRepository;
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
        // jobRepository.findAll()-> Hibernate generates SELECT * FROM job -> Returns all jobs from database 
    }
    public  Job getJobById(Integer id){
        return jobRepository.findById(id).orElse(null);
        // Hibernate generates SELECT * FROM job WHERE id=? -> Reurn job if found, null if not-> .orElse(null)means if not found then return null.
        // List<Job>jobs=getAllJobs();   // first get all jobs 
        // for(Job job:jobs){  // this is called for each loop -> it goes through every job in the list one by one -> each time , current job is stored in job variable .
        //     if(job.getId()==id){  //check if this job's id matches what was requested -> if yes then return that job.
        //         return job;
        //     }
        // }
        // return null;   // if not job foind with theat id-> return nothing-> we will handle this better later with proper error handling .
    }
    public void addJob(Job job){
        jobRepository.save(job);
        // Hibernate generates INSERT INTO job VALUES(...)-> Saves job permanently to database.
    }
}
