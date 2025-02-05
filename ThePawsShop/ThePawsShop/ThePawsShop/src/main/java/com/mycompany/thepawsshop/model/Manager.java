package com.mycompany.thepawsshop.model;
/**
 *
 * @author dhanu
 */

// getters and setters are used here // 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends User {
    
    // Constructor that calls the superclass (User) constructor
    public Manager(String username, String password) {
        super(username, password);  // Initialize username and password in User class
    }

    // Method to save manager details to a file
    public boolean saveToFile() {
        try {
            File file = new File("managers.txt");
            
            // Create the file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Write manager credentials to the file (append mode)
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                bw.write(this.getUsername() + "," + this.getPassword() + "\n");
                bw.flush();  // Ensure the data is written to the file
            }
            return true;  // Successfully saved
        } catch (IOException e) {
            e.printStackTrace();
            return false;  // Error occurred while saving
        }
    }
}