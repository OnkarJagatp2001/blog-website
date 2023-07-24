package com.blogsite.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogsite.Repository.BlogRepository;
import com.blogsite.model.Blog;
import com.blogsite.model.HomePageBlogs;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Blogapi")
public class BlogController {
	
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@PostMapping("/addblog")
	public boolean add(@RequestBody Blog blog)
	{
		blogRepository.save(blog);
		return true;
	}
	
	@GetMapping("/getblogbyid/{blog_id}")
	public Blog getBbyid(@PathVariable int blog_id)
	{
		Blog blog = blogRepository.findById(blog_id).orElseThrow(null);
		return blog;
	}
	
//	@GetMapping("/getAllblog")
//	public ResponseEntity<List<Blog>> getblog()
//	{	System.out.println("in getblog");
//		List<Blog>blogList = new ArrayList<>();
//		blogRepository.findAll().forEach(blogList::add);
//		
//		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
//	}
	
	@GetMapping("/getAllblog")
	public List<HomePageBlogs> getblog()
	{	
		List<HomePageBlogs>AllBlog=new ArrayList<>();
		String query="select b.*,u.user_name,u.name from blog b left join users u on b.user_id=u.user_id order by b.blog_id desc limit 10";
		Map<String, Object>params=new HashMap<>();
	   List<Map<String, Object>> resultList = namedParameterJdbcTemplate.queryForList(query,params);

        for (Map<String, Object> result : resultList) {
            int user_Id = (int) result.get("user_id");
            String blog_title = (String) result.get("blog_title");
            String blog_text = (String) result.get("blog_text");
            String tags = (String) result.get("tags");
            int blog_id = (int) result.get("blog_id");
            int views = (int) result.get("views");
            int likes = (int) result.get("likes");
            String Name = (String) result.get("name");
            String userName = (String) result.get("user_name");
            HomePageBlogs blog = new HomePageBlogs(user_Id,blog_title,blog_text,tags,blog_id,views,likes,Name,userName);
            AllBlog.add(blog);
        }
        return AllBlog;
//		return new ResponseEntity<List<Blog>>(blogList,HttpStatus.OK);
	}
	
	@GetMapping("/getblog/{user_id}")
	public List<Blog> getblog(@PathVariable int user_id)
	{
		List<Blog>blogs=new ArrayList<>();
		String query="select * from blog where user_id=:user_id";
		Map<String, Object>params=new HashMap<>();
		params.put("user_id", user_id);
	   List<Map<String, Object>> resultList = namedParameterJdbcTemplate.queryForList(query, params);

        for (Map<String, Object> result : resultList) {
            int user_Id = (int) result.get("user_id");
            String blog_title = (String) result.get("blog_title");
            String blog_text = (String) result.get("blog_text");
            String tags = (String) result.get("tags");
            int blog_id = (int) result.get("blog_id");
            int views = (int) result.get("views");
            int likes = (int) result.get("likes");
            Blog blog = new Blog(user_Id,blog_title,blog_text,tags,blog_id,views,likes);
            blogs.add(blog);
//            System.out.println("BOLG ID = "+blog_id);
        }
        return blogs;

	}
	@GetMapping("/getblogbytag/{tag}")
	public List<Blog> getblogbytag(@PathVariable String tag)
	{
		System.out.println(tag);
		List<Blog>blogs=new ArrayList<>();
		String query="select * from blog where tags like :tag";
		Map<String, Object>params=new HashMap<>();
		params.put("tag", "%"+tag+"%");
	   List<Map<String, Object>> resultList = namedParameterJdbcTemplate.queryForList(query, params);

        for (Map<String, Object> result : resultList) {
            int user_Id = (int) result.get("user_id");
            String blog_title = (String) result.get("blog_title");
            String blog_text = (String) result.get("blog_text");
            String tags = (String) result.get("tags");
            int views = (int) result.get("views");
            int likes = (int) result.get("likes");
            Blog blog = new Blog(user_Id,blog_title,blog_text,tags,views,likes);
            blogs.add(blog);
        }
        return blogs;

	}
	@GetMapping("/views/{blog_id}")
	public boolean viewsUpdate(@PathVariable int blog_id)
	{
		System.out.println(blog_id);
		String query="update blog set views=views+1 where blog_id=:blog_id";
		Map<String, Object>params=new HashMap<>();
		params.put("blog_id", blog_id);
		namedParameterJdbcTemplate.update(query, params);
		return true;
	}
	@GetMapping("/like/{blog_id}")
	public void likesUpdate(@PathVariable int blog_id)
	{
		String query="update blog set likes=likes+1 where blog_id=:blog_id";
		Map<String, Object>params=new HashMap<>();
		params.put("blog_id", blog_id);
		namedParameterJdbcTemplate.update(query, params);

	}

	@GetMapping("/liked/{blog_id}")
	public boolean likesdec(@PathVariable int blog_id)
	{
		String query="update blog set likes=likes-1 where blog_id=:blog_id";
		Map<String, Object>params=new HashMap<>();
		params.put("blog_id", blog_id);
		namedParameterJdbcTemplate.update(query, params);
		return true;
	}
	
	

}
