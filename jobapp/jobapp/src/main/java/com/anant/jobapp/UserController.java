package com.anant.jobapp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController (UserService userService){
        this.userService=userService;
    }

    @PostMapping("/auth/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("/auth/login")
    public String loginUser(@RequestBody User user){
        return "Login successful";
    }
}
