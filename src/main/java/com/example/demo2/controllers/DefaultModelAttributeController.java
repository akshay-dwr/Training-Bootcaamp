package com.example.demo2.controllers;

import com.example.demo2.beans.Login;
import com.example.demo2.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public User getDefaultUserData(){
        return new User();
    }

    @ModelAttribute("genderItems")
    public List<String> getGenderItems(){

        return Arrays.asList(new String[]{"Male", "Female", "Other"});
    }

    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }
}
