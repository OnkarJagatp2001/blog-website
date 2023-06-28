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
    
    public User findUserByUserName(String userName) {
        return userRepository.findByuserName(userName);
//        return user;
    }
    
    public boolean isUsernameAlreadyExists(String userName) {
        User user = userRepository.findByuserName(userName);
        if(user.getUserName() != null)
        {
        	return false;
        }
//        return user != null;
        return true;
    }
}
