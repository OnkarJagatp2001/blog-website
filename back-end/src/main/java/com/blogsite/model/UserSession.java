package com.blogsite.model;

public class UserSession {

	private int userId;
	
	private String name;
	

	private String userName;

	
	private String userEmail;
	
	
	private String userPass;
	
	
	private String userProf;
	
	
	private int userAge;

	
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
    
    public int  getUserId() {
        return userId;
    }

    public void setgetUserId(int userId) {
        this.userId = userId;
    }
    
    
    public UserSession(String name, String userName, String userEmail, int userId, String userProf, int userAge, String gender) {
        this.name = name;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userId = userId;
        this.userProf = userProf;
        this.userAge = userAge;
        this.gender = gender;
    }

	public UserSession() {
		super();
	}    
	
}
