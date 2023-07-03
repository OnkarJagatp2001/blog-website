package com.blogsite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Blog")
public class Blog {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blog_id;   //primary key
	private int user_id;
	@Column(length = 1000)
	private String blog_title;
	@Column(length = 10000000)
	private String blog_text;
	private String tags;
	private int views;
	private int likes;
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
	public Blog( int user_id, String blog_title, String blog_text, String tags, int views, int likes) {
		super();
		this.user_id = user_id;
		this.blog_title = blog_title;
		this.blog_text = blog_text;
		this.tags = tags;
		this.views = views;
		this.likes = likes;
	}
	public Blog() {
		super();
	}
	
}

