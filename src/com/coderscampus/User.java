package com.coderscampus;

public class User {

	private String username;
	private String password;
	private String name;
	int i = 0;
	
	void createUser (int i, String username, String password, String name) {
		User[] theNewUser = new User[i];
		this.username=username;
		this.password=password;
		this.name=name;
		theNewUser[i].setUsername(username);
		theNewUser[i].setPassword(password);
		theNewUser[i].setName(name);
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