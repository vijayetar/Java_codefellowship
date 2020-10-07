package com.vijayetar.Codefellowship.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Scope("request")
@Controller
public class HomeController {

    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @GetMapping("/cool")
    public String showCool(Principal principal, Model m){
        System.out.println("here inside the cool documents  "+ principal.getName());
        m.addAttribute("currentuser", principal.getName());
        return "cool";
    }

}
