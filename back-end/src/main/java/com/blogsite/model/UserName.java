package com.blogsite.model;
public class UserName {	
	private int user_id;
	private int blog_id;
	private String comment;
	private String date;	
	private String name;
	
	public UserName(int user_id, int blog_id, String comment, String date,String name) {
		super();
		this.user_id = user_id;
		this.blog_id = blog_id;
		this.comment = comment;
		this.date = date;
		this.name=name;
	}
	
	public UserName() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
