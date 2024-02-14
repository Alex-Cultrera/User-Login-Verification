package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;



public class UserLoginApplication {

	public static void main(String[] args) {
	
		BufferedReader input = null;
		BufferedReader input2 = null;
		int length = 0;
		int i = 0;
		String newbieUsername = null;
		String newbiePassword = null;
		String newbieName = null;
		User user = new User();
		
		
		try {
			// READ USER DATA FROM TXT FILE
			input = new BufferedReader(new FileReader("data1.txt"));
			input2 = new BufferedReader(new FileReader("data1.txt"));
			
			// SPLIT EACH LINE OF USER DATA INTO INDIVIDUAL STRINGS
			String credential = input.readLine();
			String credential2 = input2.readLine();
			String[] credArgs;
			
			// DETERMINE LENGTH OF THE USER DATA ARRAY
			while (credential != null) {
				length++;
				credential = input.readLine();
				}
			
			User[] newb = new User[length];
			
			// FOR LOOP TO CREATE AN ARRAY OF DIFFERENT USERS
			for (i = 0; i < length; i++) {
				// STORE EACH USER DATA STRING INTO AN ARRAY
				credArgs = credential2.split(",");
				
				// ASSIGN EACH USER DATA ITEM IN THE ARRAY TO VARIABLES FOR USERNAME, PASSWORD, NAME
				newb[i]=user.createUser(credArgs[0], credArgs[1], credArgs[2]);
				newbieUsername = newb[i].getUsername();	
				newbiePassword = newb[i].getPassword();
				newbieName = newb[i].getName();
				System.out.println(newbieUsername + "," + newbiePassword + "," + newbieName);
				credential2 = input2.readLine();
				}
			
			Scanner scanner = new Scanner(System.in);
			int wrongAttempts = 0;
			int attemptLimit = 5;
			
			while (wrongAttempts < attemptLimit) {
				// GET INPUT FROM CONSOLE
				System.out.println("Enter Username:");
				String un = scanner.next();
				System.out.println("Enter Password: ");
				String pw = scanner.next();
				
				// VALIDATION 
				for (int n = 0; n<length; n++) {
					if (un != newb[n].getUsername()) {
										
					} 
										
				}
				System.out.println("Invalid login, please try again.");
				wrongAttempts++;
				continue;
			}

			
			input.close();		
			
			input2.close();
				
		} catch (FileNotFoundException x) {
			System.out.println("Oops, the file wasn't found");
			x.printStackTrace(); 
		} catch (IOException x) {
				System.out.println("Oops, there was an I/O Exception");
				x.printStackTrace();
		} finally {
			System.out.println("Closing file reader");
			try {
				input.close();
				input2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

		
		
		