package com.example.demo2.controllers;

import com.example.demo2.beans.Login;
import com.example.demo2.beans.User;
import com.example.demo2.exceptions.ApplicationException;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@ModelAttribute("login") Login login) throws ApplicationException {
        System.out.println("User - " + login.getUsername());

        User user = userRepository.searchByName(login.getUsername());
        if(user == null){
           throw new ApplicationException("User Not Found. Not Authorized!");
        }
        return "search";
    }
}
