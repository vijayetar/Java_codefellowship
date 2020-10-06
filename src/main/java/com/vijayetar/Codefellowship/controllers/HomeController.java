package com.vijayetar.Codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/cool")
    public String showCool(){
        return "cool";
    }

}
