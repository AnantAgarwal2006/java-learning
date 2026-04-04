package com.anant.jobapp;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    User findByUsername(String username);
    // SELECT * FROM users WHERE username = ?
    /*
    When a user tries to login with a username — we need to find them by username, not by id.
    JPA has a feature called derived queries — you name the method in a specific way and JPA automatically generates the SQL.
    jpa reads the method name and auto generated sql , that is a derived query*/
}

