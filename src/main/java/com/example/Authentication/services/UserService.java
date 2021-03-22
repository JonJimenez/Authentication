package com.example.Authentication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Authentication.entities.User;
import com.example.Authentication.exceptions.UserNotFoundException;
import com.example.Authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	 private UserRepository userRepository;
	

    public User GetUserByName(String name) {
        User foundUser = userRepository.findByName(name);
        return foundUser;
    }
    public User Authenticate(String name, String password) {
    	User user = userRepository.findByName(name);
    	if(user!=null) {
        	if(user.getPassword().equals(password)) {
        		return user;
        	}
    	}
    	return null;
    }

}