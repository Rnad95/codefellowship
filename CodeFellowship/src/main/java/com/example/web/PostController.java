package com.example.web;

import com.example.Repositories.ApplicationUserRepository;
import com.example.Repositories.PostRepository;
import com.example.domain.ApplicationUser;
import com.example.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;


@Controller
public class PostController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/post/")
    public RedirectView newPost(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "body") String body
    ) {
        ApplicationUser user = applicationUserRepository.findById(id);
        Post newPost = new Post(body, user);
        postRepository.save(newPost);
        System.out.println("=============" + body);
        return new RedirectView("/");
    }

    @PostMapping("/post")
    public RedirectView addpost(Principal p, String body) {
        ApplicationUser user = applicationUserRepository.findByUsername(p.getName());
        Post newPost = new Post(body, user);
        postRepository.save(newPost);
        return new RedirectView("/");
    }

    //
//    @Autowired
//    PostRepository postRepository;
//    ApplicationUserRepository applicationUserRepository;
//
//    @GetMapping("/createPost")
//    public String getSignupPage()
//    {
//        return "/createPost.html";
//    }
//
//    @PostMapping("/{username}/createPost")
//    public RedirectView createPost(String body, String username
//    ){
//        Post newPost = new Post(body,applicationUserRepository.findByUsername(username));
//        postRepository.save(newPost);
//        return new RedirectView("/"+username+"/posts");
//    }
//
//    @PostMapping("/{username}/posts")
//    public String getUserInformation(Model model, @PathVariable int Id){
//        model.addAttribute("postList",postRepository.findAllById(Id));
//        return "post";
//    }

}
