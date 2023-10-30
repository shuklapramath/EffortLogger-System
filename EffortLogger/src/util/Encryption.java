package util;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.Date;

/**
 * The CaesarCipher class implements a basic Caesar cipher algorithm for encryption and decryption.
 * It shifts each letter in the input text by a fixed number of positions in the alphabet to produce the encrypted result.
 * This class serves as a simplified prototype for testing purposes.
 * 
 * Author: Andrew Houghton
 */

public class Encryption {
	
	public static String encrypt(String content, int token) {
		/**
		 * The encrypt method takes in content (login information, logs, etc.) and a randomly generated token (the shift value).
		 * The value of the token is used to shift the ASCII value of each character in content; content will then be encrypted.
		 * The encrypted content and token are saved to the database by calling the save function.
		 */
		StringBuilder encryptedContent = new StringBuilder();
				
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			
			if (Character.isLetter(c)) {
				// The encryption formula
				c = (char) ((c - 'a' + token + 26) % 26 + 'a');
			}
			
			encryptedContent.append(c);
		}
		
		System.out.println(encryptedContent.toString()); // For testing purposes
		return encryptedContent.toString();
	}
	
	public static String decrypt(String content, int token) {
		/**
		 * The decrypt method undoes the encrypt method by shifting each character back to its original ASCII value based on the token
		 * passed in.
		 */
		StringBuilder decryptedContent = new StringBuilder();
		
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			
			if (Character.isLetter(c)) {
				// The decryption formula
				c = (char) ((c - 'a' - token + 26) % 26 + 'a');
			}
			
			decryptedContent.append(c);
		}
		
		System.out.println(decryptedContent.toString()); // For testing purposes
		return decryptedContent.toString();
	}
	
	public static int generateToken() {
		/**
		 * A random number from 1 to 26 is generated using the Random class.
		 */
		int token = 0;
		Random random = new Random();
		
		token = random.nextInt(26) + 1;
		System.out.println(token); // For testing purposes
		
		return token;
	}

	public static void main(String[] args) {
//		Database.get("Sun Oct 29 21:04:22 MST 2023");
		Database.save("9:00:00,1:00:00,4 hours,utility,other");
		
	}

}
