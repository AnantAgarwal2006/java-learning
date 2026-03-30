package com.anant.jobapp;
public class Job {
    private int id;
    private String title;
    private String description;
    private String location;
    private double salary;
    // private variable can only accessed inside the class->  nobody outside can directly do job.title  anymore-> this is called encapsulation-> protecting of the data.

    public Job(int id, String title, String description, String location, double salary) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }
    // Getters 
    // since the variables are private , you provide controlled access through these methods -> outside world uses job.getTitle() instead of job.title.
    public int getId(){
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
}
