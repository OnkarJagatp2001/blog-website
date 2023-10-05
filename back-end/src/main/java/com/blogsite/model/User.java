package com.blogsite.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "userName")
	private String userName;

	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "userPass")
	private String userPass;
	
	@Column(name = "userProf")
	private String userProf;
	
	@Column(name = "userAge")
	private int userAge;

	@Column(name = "gender")
	private String gender;
	
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

    // Getter and Setter for 'userEmail'
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    // Getter and Setter for 'userPass'
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    // Getter and Setter for 'userProf'
    public String getUserProf() {
        return userProf;
    }

    public void setUserProf(String userProf) {
        this.userProf = userProf;
    }

    // Getter and Setter for 'userAge'
    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    // Getter and Setter for 'gender'
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(String name, String userName, String userEmail, String userPass, String userProf, int userAge, String gender) {
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userProf = userProf;
        this.userAge = userAge;
        this.gender = gender;
    }

    
    public User() {}
}
