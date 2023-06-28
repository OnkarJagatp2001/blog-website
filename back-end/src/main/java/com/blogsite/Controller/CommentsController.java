package com.blogsite.Controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogsite.model.Comments;
import com.blogsite.Repository.Commentsrepository;

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
	public void postComment(@RequestBody Comments c)
	{
		commentsrepository.save(c);
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
            Date date = (Date) result.get("date");
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
	public List<Comments> getByBlog(@PathVariable int blog_id)
	{
		List<Comments>comment=new ArrayList<>();
		String query="select comment,date,user_id  from comments where blog_id=:blog_id ";
		Map<String, Object>params=new HashMap<>();
		params.put("blog_id", blog_id);
	    List<Map<String, Object>>commentList = namedParameterJdbcTemplate.queryForList(query, params);
	    for(Map<String,Object> m:commentList)
	    {
	    	String c = (String) m.get("comment");
	    	Date date=(Date) m.get("date");
	    	int user_id=(int) m.get("user_id");
	    	Comments cm=new Comments(user_id,blog_id,c,date);
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

