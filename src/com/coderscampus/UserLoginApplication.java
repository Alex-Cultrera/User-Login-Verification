package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {

	public static void main(String[] args) {
	
		UserService userService = new UserService();
		Scanner scanner;
		
		scanner = new Scanner(System.in);
		int wrongAttempts = 0;
		int attemptLimit = 5;
		
		User loggedInUser = null;
		while (wrongAttempts < attemptLimit) {
			System.out.println("Enter Username:");
			String username = scanner.next();
			System.out.println("Enter Password: ");
			String password = scanner.next();
			
			loggedInUser = userService.getUserByUsernameAndPassword(username, password);
			if (loggedInUser != null) {
				System.out.println("Welcome, " + loggedInUser.getName());
				break;
			} else {
				System.out.println("Invalid login, please try again.");
				wrongAttempts++;
			}
		}
		
		if (loggedInUser == null) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		scanner.close();
	}
}
