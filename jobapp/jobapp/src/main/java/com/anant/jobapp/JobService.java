package com.anant.jobapp;
import org.springframework.stereotype.Service;
// import java.util.ArrayList;  remove this now as we a using the database to store the data .
import java.util.List;

//private List<Job> jobs = new ArrayList<>(); // real list, can add/remove
@Service
public class JobService {
    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
        // jobRepository.findAll()-> Hibernate generates SELECT * FROM job -> Returns all jobs from database 
    }
    public  Job getJobById(Integer id){
        return jobRepository.findById(id).orElse(null);
        // Hibernate generates SELECT * FROM job WHERE id=? -> Reurn job if found, null if not-> .orElse(null)means if not found then return null.
    }
    public void addJob(Job job){
        jobRepository.save(job);
        // Hibernate generates INSERT INTO job VALUES(...)-> Saves job permanently to database.
    }
    public boolean deleteJob(Integer id){
        if(jobRepository.existsById(id)){
            // checks if a job with this id exists in database ->Returns tue or false .
            jobRepository.deleteById(id);
            //Hiberante generates DELETE FORM job WHERE id=? permanently removes form database.
            return true;
        }
        // why check first ? if you try to delete something taht does not exists ->better to return false than crash-> this is called defensive programming.
        return false;
        // boolean return type-> return true if deleted successfully -> return false if job not found.
    }
    public Job updateJob(Integer id,Job updatedJob){

        Job existingJob=jobRepository.findById(id).orElse(null);
        // first find the existing job in database 

        if(existingJob !=null){
            // only update if job actually exists .

            // replace old values with new one by one
            existingJob.setTitle(updatedJob.getTitle());

            existingJob.setDescription(updatedJob.getDescription());

            existingJob.setLocation(updatedJob.getLocation());
            
            existingJob.setSalary(updatedJob.getSalary());

            return jobRepository.save(existingJob);
            // save upload job back to database->Hiberante generates UPDATE job SET ... WHERE id=? -> returns the updated job
        }
        return null;
        // Why not just save 'updatedJob' directly? because      updatedJob comes from request and has no id context so we find existing job first , update its fields then save-> this way we keep the same id and only change what was sent.
    }
}
