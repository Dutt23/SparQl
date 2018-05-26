package com.stackroute.sparQL.model;

public class AdminUser {

	private int userId;
	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AdminUser() {

	}

	public AdminUser(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

}
