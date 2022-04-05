package com.example.web;

import com.example.Repositories.ApplicationUserRepository;
import com.example.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    ApplicationUserRepository applicationUserRepository;


    //***************************************** Log In *****************************************

    @GetMapping("/login")
    public String getLogin(){
        return "login.html";
    }


//    ***************************************** Sign up ******************

    @GetMapping("/signup")
    public String getSignupPage()
    {
        return "/signup.html";
    }

    @PostMapping("/signup")
    public RedirectView signupUser(@RequestParam String username,
                             @RequestParam String password,
                              String firstName,
                              String lastName,
                              String datOfBirth,
                              String bio
                             ){

            ApplicationUser appuser = new ApplicationUser(username,
                    encoder.encode(password),firstName,lastName,
                    datOfBirth,bio);
            applicationUserRepository.save(appuser);
            return new RedirectView("/"+username+"/");
        }

}
