package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.configs.CustomLogoutSuccessHandler;
import com.vijayetar.Codefellowship.models.user.ApplicationUser;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import com.vijayetar.Codefellowship.models.user.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.OneToMany;
import java.security.Principal;
import java.sql.Date;

@Controller
public class ApplicationUserController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

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

    @GetMapping("/user/{id}")
    public String showUserDetailsPage(@PathVariable Long id, Model m, Principal principal){
        ApplicationUser user = applicationUserRepository.findById(id).get();
        System.out.println("here from the get route "+user.posts.get(0));
        m.addAttribute("user", user);
        m.addAttribute("currentuser", principal.getName());
//        ApplicationUser loggedInUser = applicationUserRepository.findByUsername(principal.getName());
//        m.addAttribute("currentUserId", loggedInUser.id );
        if(user == null) {
            m.addAttribute("userDoesNotExist", true);
        }
        return "userdetail";
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
    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() { //https://www.baeldung.com/spring-security-custom-logout-handler
        return new CustomLogoutSuccessHandler();
    }

    @GetMapping("/username")
    @ResponseBody
    public String currentUserNameSimple() { // https://www.baeldung.com/get-user-in-spring-security
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

}
