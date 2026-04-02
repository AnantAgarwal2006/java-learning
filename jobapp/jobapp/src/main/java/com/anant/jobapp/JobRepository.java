package com.anant.jobapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> 
{

}
//JpaRepository<Job, Integer> -> Job = which entity this repository manages ->Integer = the type of the primary key(out id is int)
//  extends JpaRepository -> your repository inherits all standard database methods automatically-> findAll(),findById(),save(),deleteById()-> all available without writing a single code.

// This is the power of Spring Data JPA — zero boilerplate database code.
// interface->not a class -> an interface -> you define what methods you need , someone else implements them-> JPA implements everything automatically .