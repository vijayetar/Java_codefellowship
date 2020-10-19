package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.models.posts.Post;
import com.vijayetar.Codefellowship.models.posts.PostRepository;
import com.vijayetar.Codefellowship.models.user.ApplicationUser;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
    @GetMapping("/feed")
    public String getAllFeeds(Principal principal, Model m){
        ApplicationUser thisUser = applicationUserRepository.findByUsername(principal.getName());
        m.addAttribute("currentuser", principal.getName());
        Set<ApplicationUser> myUsers = thisUser.usersIFollow;
        m.addAttribute("allUsersIFollow", myUsers);
        return "feed";
    }

    @PostMapping("/savePost")
    public RedirectView makeNewPost(String body, long id, Principal principal){
        Post post = new Post(body);
        ApplicationUser appUser = applicationUserRepository.getOne(id);
        post.applicationUser = appUser;
        postRepository.save(post);
        appUser.posts.add(post);
        applicationUserRepository.save(appUser);
        System.out.println("here are the posts  "+ appUser.posts);
        return new RedirectView("/myprofile");
    }
}
