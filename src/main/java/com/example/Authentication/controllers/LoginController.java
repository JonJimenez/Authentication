package com.example.Authentication.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Authentication.entities.User;
import com.example.Authentication.services.UserService;


@Controller
public class LoginController {
	
	@Autowired
	UserService userservice;
	

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
        return "greeting";
    }


    @GetMapping("/login")
    public String showLogin(ModelMap map) {
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@RequestParam String name,
    		@RequestParam String password,ModelMap model){
    	User user = userservice.Authenticate(name, password);
    	if(user!=null) {
    		model.addAttribute(user);
    		return "userDetails";
    	}
    	return "errorLogin";
    }
}