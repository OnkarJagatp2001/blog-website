package com.blogsite.Controller;

import java.util.HashMap;
import java.util.List;
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
import com.blogsite.model.UserName;
import com.blogsite.model.UserSession;
import com.blogsite.service.UserService;



@RestController
@RequestMapping("/userapi")
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
	
	public boolean getuname(String usern)
	{
		String query = "select count(*) from users where user_name = ?";
		int c = jdbcTemplate.queryForObject(query, Integer.class, usern);
		return c > 0;
	}

	@PostMapping("/users")
	public boolean createNewUser(@RequestBody User user ) {
			if(getuname(user.getUserName()) == true)
			{
				return false;
			}
			
			userRepository.save(user);
			return true;
	}
	@PostMapping("/login")
	public boolean login(@RequestBody User user)
	{
//		String query = "select count(*) from users where user_name = :uname && user_pass=:pass";	
//		Map<String, Object>params=new HashMap<>();
//		params.put("user_name", user.getUserName());
//		params.put("user_pass",user.getUserPass());
////		System.out.println(user.getUserName());
////		System.out.println(user.getUserPass());
//		List<Map<String, Object>> resultList = namedParameterJdbcTemplate.queryForList(query, params);
//        
//		for (Map<String, Object> result : resultList) {
//         
//            String u = (String) result.get("user_name");
//            String p = (String) result.get("user_pass");
//            System.out.println(u);
//            System.out.println(p);
//    
//        }
//		if(resultList.size()==1)
//			return true;
//		else 
//			return false;
//		System.out.println(user.getUserName());
		String query = "select user_pass from users where user_name = :uname ";
		Map<String, Object>params=new HashMap<>();
		params.put("uname", user.getUserName());
		
		String s = "";
		try {
			s = namedParameterJdbcTemplate.queryForObject(query, params, String.class);
		}catch(Exception e)
		{
			s = "";
		}
		
		System.out.print(s);
		if(s.equals(user.getUserPass())) {
			return true;
		}
		else
			return false;
	
	}
	
	@PostMapping("/users/check")
	public boolean checkNewUser(@RequestBody User user ) {
		return !getuname(user.getUserName());
}
	
	@GetMapping("/sp/{userId}")
	public UserName gt(@PathVariable int userId) {		
		User users = userRepository.findById(userId).orElseThrow(null);
		UserName u=new UserName(users.getUserName());
		return u; 
		
	}
	
	@GetMapping("/users/{userName}")
	public UserSession getdata(@PathVariable String userName)
	{
		String query = "select * from users where user_name = :userName";
		Map<String, Object>params=new HashMap<>();
		params.put("userName", userName);
		
		   List<Map<String, Object>> resultList = namedParameterJdbcTemplate.queryForList(query, params);
		   
		   UserSession u = null;
	        for (Map<String, Object> result : resultList) {
	            int user_Id = (int) result.get("user_id");
	            String username = (String) result.get("user_name");
	            String userEmail = (String) result.get("user_email");
	            String userProf = (String) result.get("user_prof");
	            int userAge = (int) result.get("user_age");
	            String gender = (String) result.get("gender");
	            String name = (String) result.get("name"); 
	            System.out.println(user_Id);
	            u =	new UserSession(name, username, userEmail, user_Id, userProf, userAge, gender);
	        }
	        System.out.println(u.getUserName());
		return u;
	}
	
	
}
