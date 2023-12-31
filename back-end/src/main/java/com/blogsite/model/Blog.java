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
	private int bid;
	
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
	public Blog(int user_id2, String blog_title2, String blog_text2, String tags2, int blog_id2, int views2,
			int likes2) {
		// TODO Auto-generated constructor stub
		super();
		this.user_id = user_id2;
		this.blog_title = blog_title2;
		this.blog_text = blog_text2;
		this.tags = tags2;
		this.bid = blog_id2;
		this.views = views2;
		this.likes = likes2;
	}

	
}

