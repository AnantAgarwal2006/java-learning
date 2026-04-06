package com.anant.jobapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User registerUser(User user){
        String hashedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
        return user;
    }
    public User findByUsername(String username){

        return userRepository.findByUsername(username);
    }
    public String loginUser(User user){
        User existingUser=findByUsername(user.getUsername());
        if(existingUser!=null){
            if(passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
                return "Login successful";
            }else{
                return "Invalid password";
            }
        }
        return "User not found";
    }
}
