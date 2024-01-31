package com.coderscampus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

// import com.coderscampus.UserService;

public class UserLoginApplication {

	public static void main(String[] args) {
		// UserService userService = new UserService();
				
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("data1.txt"));
			
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException x) {
			System.out.println("Oops, the file wasn't found");
			x.printStackTrace(); 
		} catch (IOException x) {
				System.out.println("Oops, there was an I/O Exception");
				x.printStackTrace();
		} finally {
			try {
				System.out.println("Closing file reader");
				br.close();
			} catch (IOException x) {
				x.printStackTrace();
			}
			
		}
		
	}
	
}
			
			
/*
		1.	Collect Inputs:
				username
				password
		2.	validate whether or not username/password combination is valid by:
				-	reading this info from a file (called "data.txt")
				-	importing the data into your Java application
		3.	create a User POJO that stores the info read from the file
		4.	The User POJO should contain (username, password, name)
		5.	The file info should be stored as an Array of User objects
		6.	Once the data is stored in the Java application, you can begin process of prompting for username and password
		7.	Using a Scanner, ask the user for a username and password
		8.	Validate this input against the Array of User objects
		9.	Iterate through the User objects and check to see if the username/password inputs received via the Scanner 
				match any of the User objects in the Array.
		10.	If a match is found then you should display a message that says:
				Welcome {insert user's name here}
				Note: you should populate the {insert user's name here} portion with 
				the name of the User which matches the inputted username/password.
		11.	Once a user has successfully logged in, the program can terminate.
		12.	If no match is found then you should display a message that says:
				Invalid login, please try again.
		13.	In the event that there's an invalid login attempt, the user should only be given 5 chances in total to login. 
		14.	If the user fails to login after their 5th attempt, the program should output a message that states:
				Too many failed login attempts, you are now locked out.
				And the program should terminate.
		
		
		Determining a Match
			A match is found when two conditions are met:
			
			  1. The inputted username is a case insensitive match with the username property in the User object
			  2. The inputted password is a case sensitive match with the password property in the User object.


		UserService class 
				validate if username/password matches what's in our User Array. 
				provide the service of reading the data from the file and creating the User Array.
		User POJO Class
				stores the info read from the file
				contains (username, password, name)
				file info should be stored as an Array of User objects
		UserLoginApplication Class
				houses the "public static void main" method.
		
*/
