package com.coderscampus;


public class User {

	private String username;
	private String password;
	private String name;
		
	
	public User createUser (String username, String password, String name) {
		User theUser = new User();
		this.username=username;
		this.password=password;
		this.name=name;
		theUser.setUsername(username);
		theUser.setPassword(password);
		theUser.setName(name);
		return theUser;
		}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}