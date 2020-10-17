package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.models.posts.Post;
import com.vijayetar.Codefellowship.models.posts.PostRepository;
import com.vijayetar.Codefellowship.models.user.ApplicationUser;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
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
