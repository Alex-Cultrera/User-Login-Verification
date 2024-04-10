package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	
	private String FILENAME = "data1.txt";
	
	public User[] readUsersFromFile() {
		int arrayLength = getLength();
		User[] newUsers = new User[arrayLength]; 
		BufferedReader buffRead;
		try {
			buffRead = new BufferedReader(new FileReader(FILENAME));
			
			for (int i = 0; i < arrayLength; i++) {
				String userInfoStr = buffRead.readLine();
				String[] userInfo = userInfoStr.split(",");
				newUsers[i] = new User(userInfo[0], userInfo[1], userInfo[2]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Oops, the file wasn't found");
			e.printStackTrace(); 
		} catch (IOException e) {
			System.out.println("Oops, there was an I/O Exception");
			e.printStackTrace();
		}
		
		return newUsers;
		
	}
	
	// METHOD TO DETERMINE LENGTH OF THE USER DATA ARRAY
		public int getLength() {
			int length = 0;
			try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
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
	
}


