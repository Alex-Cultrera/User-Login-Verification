package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;



public class UserLoginApplication {

	public static void main(String[] args) {
	
		BufferedReader input = null;
		int arrayLength = 0;
		int i = 0;
		String newbUsername = null;
		String newbPassword = null;
		String newbName = null;
		User user = new User();
		UserService userService = new UserService();
		Scanner scanner;
		
		
		try {
			// READ USER DATA FROM TXT FILE
			input = new BufferedReader(new FileReader("data1.txt"));
												
			// STORE EACH USER DATA STRING INTO AN ARRAY
			// ASSIGN EACH USER DATA ITEM IN THE ARRAY TO VARIABLES FOR USERNAME, PASSWORD, NAME
			arrayLength = userService.getLength(input);
			User[] newb = new User[arrayLength];
			for (i=0; i<arrayLength; i++) {
				newb[i]=user.createUser(userService.credentialArray(arrayLength, input)[0], 
					userService.credentialArray(arrayLength, input)[1], 
					userService.credentialArray(arrayLength, input)[2]);
				newbUsername = newb[i].getUsername();	
				newbPassword = newb[i].getPassword();
				newbName = newb[i].getName();
			}
						
				
			// OUTPUT USER DATA IN CONSOLE FOR TESTING
			System.out.println(newbUsername + "," + newbPassword + "," + newbName);
			
			
			// GET INPUT FROM CONSOLE
			scanner = new Scanner(System.in);
			int wrongAttempts = 0;
			int attemptLimit = 5;
			
			while (wrongAttempts < attemptLimit) {
				System.out.println("Enter Username:");
				String un = scanner.next();
				System.out.println("Enter Password: ");
				String pw = scanner.next();
				
				// VALIDATION 
				for (int n = 0; n < arrayLength; n++) {
					if (un == newb[n].getUsername()) {
						for (int m = 0; m < arrayLength; m++) {
							if (pw == newb[m].getPassword()) {
								System.out.println("Welcome" + newb[m].getName() + "!");
								System.exit(0);
							}
							else {
								System.out.println("Invalid password, please try again.");
								wrongAttempts++;
								continue;
							}
						}
					} 
					else if (un != newb[n].getUsername()) {
						System.out.println("Invalid username, please try again.");
						wrongAttempts++;
						continue;
					}
					
				}
			System.out.println("Too many failed login attempts, you are now locked out.");
			System.exit(0);
			}
			
			input.close();		
							
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
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

		
		
		