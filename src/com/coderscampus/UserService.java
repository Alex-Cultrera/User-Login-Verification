package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UserService {

	int length = 0;
	int i = 0;
	BufferedReader br;
	String[] credentialArg;
	int argLength = 0;
	BufferedReader buffRead;
	User theUser = new User();
	String newbUsername = null;
	String newbPassword = null;
	String newbName = null;
	
	// METHOD TO DETERMINE LENGTH OF THE USER DATA ARRAY
	public int getLength (BufferedReader br) {
		this.br=br;
		try {
			String credential = br.readLine();
			while (credential != null) {
				length++;
				credential = br.readLine();
				}			
		} catch (FileNotFoundException x) {
			System.out.println("Oops, the file wasn't found");
			x.printStackTrace(); 
		} catch (IOException x) {
			System.out.println("Oops, there was an I/O Exception");
			x.printStackTrace();
		} 
		return length;
	}
	
	
	
	// METHOD WITH FOR LOOP, TO CREATE AN ARRAY OF DIFFERENT USERS
	public User[] credentialArray (int argLength, BufferedReader buffRead) {
		this.argLength=argLength;
		this.buffRead=buffRead;
		User[] userCredArg = new User[argLength];
		try {
			String cred = buffRead.readLine();
			for (i = 0; i < argLength; i++) {
				credentialArg = cred.split(",");
				userCredArg[i] = theUser.createUser(credentialArg[0], credentialArg[1], credentialArg[2]);
				newbUsername = userCredArg[i].getUsername();	
				newbPassword = userCredArg[i].getPassword();
				newbName = userCredArg[i].getName();
				cred = buffRead.readLine();
				System.out.println(newbUsername + "," + newbPassword + "," + newbName);
				}				
		} catch (FileNotFoundException x) {
			System.out.println("Oops, the file wasn't found");
			x.printStackTrace(); 
		} catch (IOException x) {
			System.out.println("Oops, there was an I/O Exception");
			x.printStackTrace();
		} 
		return userCredArg;
	}
					
	
		
}
	
	
/*

	
	
	8.	Validate this input against the Array of User objects
	9.	Iterate through the User objects and check to see if the username/password inputs received via the Scanner 
			match any of the User objects in the Array.
	10.	If a match is found then you should display a message that says:
			Welcome {insert user's name here}
			Note: you should populate the {insert user's name here} portion with 
			the name of the User which matches the inputed username/password.
	11.	Once a user has successfully logged in, the program can terminate.
	12.	If no match is found then you should display a message that says:
			Invalid login, please try again.
	13.	In the event that there's an invalid login attempt, the user should only be given 5 chances in total to login. 
	14.	If the user fails to login after their 5th attempt, the program should output a message that states:
			Too many failed login attempts, you are now locked out.
			And the program should terminate.
	
	
	Determining a Match
		A match is found when two conditions are met:
		
		  1. The inputed username is a case insensitive match with the username property in the User object
		  2. The inputed password is a case sensitive match with the password property in the User object.


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
	
	

