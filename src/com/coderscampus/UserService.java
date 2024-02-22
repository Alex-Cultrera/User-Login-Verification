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
	
	
	
	// METHOD TO CREATE AN ARRAY OF DIFFERENT USERS
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
				/*  // OUTPUT THE USERNAME, PASSWORD, AND NAME FOR TESTING PURPOSES
				System.out.println(newbUsername + "," + newbPassword + "," + newbName); */
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