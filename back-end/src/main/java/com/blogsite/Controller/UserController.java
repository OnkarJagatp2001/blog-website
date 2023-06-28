package com.blogsite.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogsite.Repository.UserRepository;
import com.blogsite.model.User;
import com.blogsite.service.UserService;



@RestController
@RequestMapping("/userapi/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	UserService userservice;
	
	public String getuname(String usern)
	{
		String query = "select user_name from users where user_name = :user_name";
		  Map<String,Object>par = new HashMap<>();
		  par.put("user_name",usern);
		Map<String, Object> params = new HashMap<String, Object>();
		return namedParameterJdbcTemplate.queryForObject(query, par, String.class);	
	}

	@PostMapping("/users")
	public boolean createNewUser(@RequestBody User user ) {
			userRepository.save(user);
			return true;
	}
	
	@PostMapping("/check-user")
	public boolean checkNewUser(@RequestBody User user ) {
		if(getuname(user.getUserName()) != null)
		{
			return false;
		}
		return true;
	}
	
	@GetMapping("/sp/{userId}")
	public String gt(@PathVariable Long userId) {		
		User users = userRepository.findById(userId).orElseThrow(null);
		
		return users.getUserName();
		
	}
	
	@GetMapping("/users/{userName}")
	public User un(@PathVariable String userName)
	{
		System.out.print(userName);
		return userservice.findUserByUserName(userName);
	}
}
