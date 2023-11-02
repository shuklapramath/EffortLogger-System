package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {
	
	public static void saveLog(String content) {
		/**
		 * Saves the encrypted message and token (shift value) to the database. If the database does not exist, it is created.
		 * The Date class is being used for testing purposes only. A serial value will take its place once a proper database is implemented.
		 * Each entry is in the format Date,content,token. These elements are delimited by commas to facilitate easy parsing or extraction 
		 * of the individual components when needed.
		 */
		String database = "src/database/logs.txt";
		Date date = new Date();
		int token = Encryption.generateToken();
		
		try {
			FileWriter fileWriter = new FileWriter(database, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(date + "," + Encryption.encrypt(content, token) + "," + Integer.toString(token));
			bufferedWriter.newLine();
            bufferedWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getLog(String entryId) {
		/**
		 * Reads from the database line by line until the entryId finds a match. If a match is found, return decrypted content. Otherwise, return null.
		 */
		String database = "src/database/logs.txt";
		
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 7);
                String dateStr = parts[0];
                String content = parts[1] + "," + parts[2] + "," + parts[3] + "," + parts[4] + "," + parts[5];

                if (dateStr.equals(entryId)) {
                        return Encryption.decrypt(content, Integer.parseInt(parts[6]));
                }
            }
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
	}
	
	public static List<String> getAllDates() {
	    List<String> dates = new ArrayList<>();

	    String database = "src/database/logs.txt";

	    try (BufferedReader br = new BufferedReader(new FileReader(database))) {
	        String line;

	        while ((line = br.readLine()) != null) {
	            String[] parts = line.split(",", 7);
	            String dateStr = parts[0];
	            dates.add(dateStr);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return dates;
	}
	
	public static void saveAccount(String username, String password) {
		String database = "src/database/accounts.txt";
		int token = Encryption.generateToken();
		
		try {
			FileWriter fileWriter = new FileWriter(database, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			bufferedWriter.write(username + "," + Encryption.encrypt(password, token) + "," + Integer.toString(token));
			bufferedWriter.newLine();
            bufferedWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getUsername(String entry) {
		String database = "src/database/accounts.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String line;
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 3);
                String username = parts[0].toLowerCase();

                if (username.equals(entry.toLowerCase())) {
                        return entry;
                }
            }
            
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
	}

	public static void main(String[] args) {

	}

}
