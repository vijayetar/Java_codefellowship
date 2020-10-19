package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.models.user.ApplicationUser;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Scope("request")
@Controller
public class HomeController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/")
    public String showHome(Model m, Principal principal){
        if (principal != null) {
            m.addAttribute("currentuser", principal.getName());
        }
        List<ApplicationUser> allUsers = applicationUserRepository.findAll();
        m.addAttribute("allUsers", allUsers);
        return "home";
    }

    @GetMapping("/cool")
    public String showCool(Principal principal, Model m){
        System.out.println("here inside the cool documents  "+ principal.getName());
        m.addAttribute("currentuser", principal.getName());
        return "cool";
    }

}
