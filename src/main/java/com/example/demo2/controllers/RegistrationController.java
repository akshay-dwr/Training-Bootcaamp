package com.example.demo2.controllers;

import com.example.demo2.beans.User;
import com.example.demo2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//JSR 380
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(Date.class, "dateOfBirth",
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){
        System.out.println("In Registration Controller");
        System.out.println("Date Came is " + user.getDateOfBirth());

        if(result.hasErrors()){
            return "register";
        }
        userRepository.save(user);
        model.addAttribute("dataSaved", "User is registered Successfully!");
        return "login";
    }
}
