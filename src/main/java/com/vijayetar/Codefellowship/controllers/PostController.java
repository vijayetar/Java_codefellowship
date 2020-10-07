package com.vijayetar.Codefellowship.controllers;

import com.vijayetar.Codefellowship.models.posts.Post;
import com.vijayetar.Codefellowship.models.posts.PostRepository;
import com.vijayetar.Codefellowship.models.user.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;
    @Autowired
    PostRepository postRepository;
    @PostMapping("/savePost")
//    public RedirectView makeNewPost(String body, long id){
//        Post post = new Post(body, )
//    }
}
