package com.blogsite.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogsite.model.Comments;
import com.blogsite.model.UserName;
import com.blogsite.Repository.Commentsrepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CommentsController {
	@Autowired
	Commentsrepository commentsrepository;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/post")
	public boolean postComment(@RequestBody Comments c)
	{
		commentsrepository.save(c);
		return true;
	}

	@GetMapping("/getbyuser/{user_id}")
	public List<Comments> getByUser(@PathVariable int user_id)
	{
		List<Comments>comments=new ArrayList<>();
		String query="select * from comments where user_id=:user_id";
		Map<String, Object>params=new HashMap<>();
		params.put("user_id", user_id);
	   List<Map<String, Object>> commentList = namedParameterJdbcTemplate.queryForList(query, params);

        for (Map<String, Object> result : commentList) {
        	
            int user_Id = (int) result.get("user_id");
            int blog_id = (int) result.get("blog_id");
            String date = (String) result.get("date");
            String comment = (String) result.get("comment");
           
            Comments c = new Comments(user_Id,blog_id,comment,date);
            comments.add(c);
        }
        return comments;
	}
	
	
	
	@GetMapping("/getbyuserandblog/{user_id}/{blog_id}")
	public String getByUser(@PathVariable int user_id,@PathVariable int blog_id)
	{
		
		String query="select comment from comments where user_id=:user_id and blog_id=:blog_id";
		Map<String, Object>params=new HashMap<>();
		params.put("user_id", user_id);
		params.put("blog_id", blog_id);
	    Map<String, Object> commentList = namedParameterJdbcTemplate.queryForMap(query, params);

       String comment = (String) commentList.get("comment");
       return comment;  
	}
	
	
	@GetMapping("/getbyblog/{blog_id}")
	public List<UserName> getByBlog(@PathVariable int blog_id)
	{
		List<UserName>comment=new ArrayList<>();
		String query="select comments.comment,comments.date,comments.user_id,Users.user_name  from comments  join Users on Users.user_id=comments.user_id where blog_id=:blog_id;";
		Map<String, Object>params=new HashMap<>();
		params.put("blog_id", blog_id);
	    List<Map<String, Object>>commentList = namedParameterJdbcTemplate.queryForList(query, params);
	    for(Map<String,Object> m:commentList)
	    {
	    	String c = (String) m.get("comment");
	    	String date=(String) m.get("date");
	    	int user_id=(int) m.get("user_id");
	    	String name=(String)m.get("user_name");
	    	UserName cm=new UserName(user_id,blog_id,c,date,name);
	    	comment.add(cm); 	
	    }
       
       return comment; 
	}
	
	
	@DeleteMapping("/deletecomment/{comment_id}")
	public boolean deleteComment(@PathVariable Long comment_id)
	{
		
       commentsrepository.deleteById(comment_id);
       Optional<Comments> c=commentsrepository.findById(comment_id);
       if(c.isPresent())
       {
    	   return false;
       }
       else
       {
    	   return true;
       }
	}
	

	
}

