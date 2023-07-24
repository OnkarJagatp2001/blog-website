package com.blogsite.model;

public class HomePageBlogs {
	private int user_id;
	private String blog_title;
	private String blog_text;
	private String tags;
	private int views;
	private int likes;
	private int bid;
	private String name;
	private String userName;
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for 'userName'
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getBlog_title() {
		return blog_title;
	}
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	public String getBlog_text() {
		return blog_text;
	}
	public void setBlog_text(String blog_text) {
		this.blog_text = blog_text;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public HomePageBlogs(int user_id2, String blog_title2, String blog_text2, String tags2, int blog_id2, int views2,
			int likes2, String name, String userName) {
		this.user_id = user_id2;
		this.blog_title = blog_title2;
		this.blog_text = blog_text2;
		this.tags = tags2;
		this.bid = blog_id2;
		this.views = views2;
		this.likes = likes2;
		this.name = name;
		this.userName = userName;
	}
	
	
}
