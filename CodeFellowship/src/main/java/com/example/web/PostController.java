package com.example.web;

import com.example.Repositories.ApplicationUserRepository;
import com.example.Repositories.PostRepository;
import com.example.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/createPost")
    public String getSignupPage()
    {
        return "/createPost.html";
    }

    @PostMapping("/{username}/createPost")
    public RedirectView createPost(String body, String username
    ){
        Post newPost = new Post(body,applicationUserRepository.findByUsername(username));
        postRepository.save(newPost);
        return new RedirectView("/"+username+"/posts");
    }

    @PostMapping("/{username}/posts")
    public String getUserInformation(Model model, @PathVariable int Id){
        model.addAttribute("postList",postRepository.findAllById(Id));
        return "post";
    }

}
