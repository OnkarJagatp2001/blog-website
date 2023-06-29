package com.blogsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogsite.Repository.UserRepository;
import com.blogsite.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
}
