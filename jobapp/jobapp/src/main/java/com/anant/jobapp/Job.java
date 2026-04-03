package com.anant.jobapp;

import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// tells Hibernate -> "this calss represents a database table"-> Hiberante will create a job table in MySQL automatically .
public class Job {
    @Id
    // Marks id as the primary key if the table-> Primary key-> uniwue identifier for each row
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    // the above line means-> tells MySQL to increment the id ->First job gets id1, second job gets id2 automatically -> you do not need to set id manually anymore.
    private Integer id;
    private String title;
    private String description;
    private String location;
    private double salary;
    // private variable can only accessed inside the class->  nobody outside can directly do job.title  anymore-> this is called encapsulation-> protecting of the data.
    public Job(){
        //Empty constructor->JPA requires this->Hibernate needs t create empty constructor internally 
    }

    public Job(Integer id, String title, String description, String location, double salary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }
    // Getters 
    // since the variables are private , you provide controlled access through these methods -> outside world uses job.getTitle() instead of job.title.
    public Integer getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getLocation(){
        return location;
    }
    public double getSalary(){
        return salary;
    }

    //setters
    public void setId(Integer id){
        this.id=id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setLocation(String location){
        this.location=location;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
    
}
