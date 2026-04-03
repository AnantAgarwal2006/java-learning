package com.anant.jobapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
/// we need one more annotation because user is a reserved word in mysql so we need to name the table users explicitly.
// the annotation is @Table(name="users")
@Table(name="users")

public class User {
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    //It should be directly above private String username — not after the empty constructor.
    private String username;
    private String password;
    private String role;

    public User(){

    }
    public User(Integer id,String username,String password,String role){
        this.id=id;
        this.username=username;
        this.password=password;
        this.role=role;
    }

    //getters
    public Integer getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }

    // setters
    public void setId(Integer id){
        this.id=id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setRole(String role ){
        this.role=role;
    }
}

