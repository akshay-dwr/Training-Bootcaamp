package com.example.demo2.controllers;

import com.example.demo2.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/goToSearch")
    public String showSearchPage(){
        return "search";
    }

    @GetMapping("/goToLogin")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String showRegistrationPage(){
        System.out.println("Login Controller - Reached");
        return "register";
    }
}
