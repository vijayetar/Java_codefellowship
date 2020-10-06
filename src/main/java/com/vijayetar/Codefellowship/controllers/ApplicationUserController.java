package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.models.user.ApplicationUser;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signIn")
    public RedirectView signIn(
            String username,
            String password,
            String firstName,
            String lastName,
            Date dateOfBirth,
            String bio,
            String email
    ){
        System.out.println("this is from the post mapping of the signing" + username + password);
        password = passwordEncoder.encode(password);
        ApplicationUser newUser = new ApplicationUser(
                username,
                password,
                firstName,
                lastName,
                dateOfBirth,
                bio,
                email);

        applicationUserRepository.save(newUser);

        return new RedirectView("/cool"); // consider changing this to the next page
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("this is the login in part");
        return "login";
    }

    @GetMapping("/newUser")
    public String newUser(){
        System.out.println("this is the signing in part...");
        return "signIn";
    }
}
