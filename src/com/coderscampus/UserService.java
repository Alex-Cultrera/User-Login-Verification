package com.coderscampus;

public class UserService {
	
	int i=0;
	public User createUser (String username, String password, String name) {
		User[] user = new User[i];
		user[i].setUsername(username);
		user[i].setPassword(password);
		user[i].setName(name);
		return user[i];
		}
	
	String input = "exampleUsername,examplePassword,exampleName";
	
	public String[] parseText(String input) {
		this.input = input;
		String[] parse = input.split(",");
		return parse;
		
	}
	
	
	
}
