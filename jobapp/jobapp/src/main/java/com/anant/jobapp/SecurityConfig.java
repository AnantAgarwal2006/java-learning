package com.anant.jobapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// each import brings a ready made class from Spring.
// *) HttpSecurity :
//          core class used to define security rules.
//          controls: who can access what, login rules ,csrf etc.

// *) BCryptPasswordEncoder :
//          used to hash passwords; never store plain passwords -> always encrypted

// *) SecurityFilterChain:
//          defines how requests are filtered and secured 
@Configuration
// this annotation means  : tell Spring : "this class contains configuration (setup rules)"
public class SecurityConfig { // spring reads this class at startup and this class defines security rules for your app

    @Bean
    // this annotaion means:
    // -> marks a method whose return object is managed by spring 
    // spring will create and reuse that object automatically  and manage it globally 
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();// create a new encoder instance , without this password is unsafe .
        // spring will now inject this encoder anywhere you need it . by @Autowired annotation.
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/register", "/auth/login").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
    // SecurityFilterChian:defines how security behaves ,
    // HttpSecurity http:object used to configure rules.
    // throws Exception : required because setup might fail.
    // http : this is the starting point of the  configuration 
    // CSRF : cross site request forgery 
    
}
/*
Request arrives at server
↓
Spring Security intercepts it
↓
Checks SecurityFilterChain rules
↓
Is it /auth/register or /auth/login?
→ YES → permitAll → goes straight to controller
→ NO  → is user authenticated?
        → YES → goes to controller
        → NO  → returns 403 Forbidden */
/*
What You Should Be Able To Say In Interview

"I configured Spring Security to protect all endpoints except registration and login. I disabled CSRF for API testing, used BCryptPasswordEncoder for password hashing, and defined a SecurityFilterChain with custom authorization rules."

That is a complete, professional answer. */