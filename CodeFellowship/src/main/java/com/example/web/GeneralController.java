package com.example.web;

import com.example.Repositories.ApplicationUserRepository;
import com.example.domain.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class GeneralController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

// **************************************** Home Page *******************************************
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/")
    String HomePage(){
        System.out.println("The endpoint for work");
        return "homePage";
    }

// **************************************** Render the Information *******************************************

    @GetMapping("/{userName}")
    public String getUserInformation(Model model, @PathVariable String userName){
        ApplicationUser user =  applicationUserRepository.findByUsername(userName);
        model.addAttribute("user",applicationUserRepository.findByUsername(userName));
        applicationUserRepository.save(user);
        return "home";
    }

    @GetMapping("/users/{Id}")
    public String getMyInformation(Model model, @PathVariable("Id") int Id){
        ApplicationUser user =  applicationUserRepository.findById(Id);
        model.addAttribute("user",applicationUserRepository.findById(Id));
        return "home";
    }


}
