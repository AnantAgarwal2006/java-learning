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
//If you name it users directly, you can avoid the conflict. @Table(name="users") just makes it explicit and safe.
@Table(name="users") 

public class User {
    
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    //It should be directly above private String username — not after the empty constructor.
    // it makes username uinque(unique=no duplicates allowed ) , it is not a primary key , id is only primary key(1 primary key per table is concept)
    // a table can have multiple unique columns but only one primary key .
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

