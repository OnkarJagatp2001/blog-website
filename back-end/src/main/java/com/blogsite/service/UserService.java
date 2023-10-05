package com.blogsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogsite.Repository.UserRepository;
import com.blogsite.exception.UserNotFoundException;
import com.blogsite.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User update(User user, Long id) { 
		  Optional<User> u=userRepository.findById(id); 
		   
		  if(u.isPresent()) 
		  { 
		   System.out.println(user); 
		   User us=u.get(); 
		   us.setGender(user.getGender()); 
		   us.setName(user.getName()); 
		   us.setUserAge(user.getUserAge()); 
		   us.setUserEmail(user.getUserEmail()); 
		   us.setUserPass(user.getUserPass()); 
		   us.setUserProf(user.getUserProf()); 
//		   us.setUserName(user.getUserName()); 
		   userRepository.save(us); 
		   System.out.println(us); 
		   return us; 
		  }else 
		  { 
		   throw new UserNotFoundException("User with id "+id+" not found."); 
		  } 
		   
		 }
    
  

    
}
