package com.coderscampus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;


public class UserService {
	
	BufferedReader br = null;
	String[] userArray;
			
	String[] users (BufferedReader br) {
		//	provide the service of reading data from the file 
		// 	and creating the user array
		
		this.br=br;
		try {
			String credentials = br.readLine();
			int x = 0;
			while (credentials != null) {
				userArray = new String[0];
				userArray = credentials.split(",");
				User newb = new User();
				newb.createUser(x, userArray[0], userArray[1], userArray[2]);
				credentials = br.readLine();
				x++;
							
			}
			br.close();
			
		
		//	handling of potential exceptions
		
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
		
		return userArray; 
		
		}
	
	 
	}
		
	


