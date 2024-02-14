package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
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
			input = new BufferedReader(new FileReader("data1.txt"));
			input2 = new BufferedReader(new FileReader("data1.txt"));
			String credential = input.readLine();
			String credential2 = input2.readLine();
			String[] credArgs;
			
			while (credential != null) {
				length++;
				credential = input.readLine();
				}
			
			User[] newb = new User[length];
			
			for (i = 0; i < length; i++) {
				credArgs = credential2.split(",");
				newb[i]=user.createUser(credArgs[0], credArgs[1], credArgs[2]);
				newbieUsername = newb[i].getUsername();	
				newbiePassword = newb[i].getPassword();
				newbieName = newb[i].getName();
				System.out.println(newbieUsername + "," + newbiePassword + "," + newbieName);
				credential2 = input2.readLine();
				}
			
			System.out.println(newb[2].getName());
			
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

		
		
		