/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepawsshop.model;
/**
 *
 * @author dhanu
 */

// getters and setters are used here // 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author dhanu
 */
public class Cashier {
    private String name;
    private String id;
    private String password;

    // Constructor
    public Cashier(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Static method to validate login from the file
    public static boolean validateLogin(String cashierId, String cashierPassword) {
        List<Cashier> cashiers = getCashiersFromFile();

        for (Cashier cashier : cashiers) {
            if (cashier.getId().equals(cashierId) && cashier.getPassword().equals(cashierPassword)) {
                return true; // Valid login
            }
        }

        return false; // Invalid login
    }

    // Helper method to read cashiers from a file and return a list of Cashier objects
    private static List<Cashier> getCashiersFromFile() {
        List<Cashier> cashiers = new ArrayList<>();

        // Read from "cashiers.txt" file (or adjust the path accordingly)
        try (BufferedReader br = new BufferedReader(new FileReader("cashiers.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(","); // Assuming the format "name,id,password"
                if (data.length == 3) {
                    cashiers.add(new Cashier(data[0].trim(), data[1].trim(), data[2].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cashiers;
    }
}
