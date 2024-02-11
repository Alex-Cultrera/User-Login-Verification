package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;


public class UserService {
	
	BufferedReader br = null;
	String[] theUserArray = null;
		
	String[] array (BufferedReader br) {
		this.br=br;
		try {
			String credentials = br.readLine();
			ArrayList<String> listOfStrings = new ArrayList<String>();
			while (credentials != null) {
				listOfStrings.add(credentials);
				credentials = br.readLine();
			}
			br.close();
		theUserArray = listOfStrings.toArray(new String[0]);
		} catch (FileNotFoundException x) {
			System.out.println("Oops, the file wasn't found");
			x.printStackTrace(); 
		} catch (IOException x) {
				System.out.println("Oops, there was an I/O Exception");
				x.printStackTrace();
		} finally {
			System.out.println("Closing file reader");
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		return theUserArray; 
		
		}
	}
		
	
	
	
	/*
	
	
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

	*/