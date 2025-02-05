/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepawsshop.controller;
import com.mycompany.thepawsshop.model.Cashier;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author dhanu
 */

public class CashierController {

    // Method to add a cashier
    public void addCashier(Cashier cashier) {
        String name = cashier.getName();
        String id = cashier.getId();
        String password = cashier.getPassword();

        if (name.isEmpty() || id.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.");
        } else {
            // Save the cashier details to a text file
            try {
                FileWriter fileWriter = new FileWriter("cashiers.txt", true); // 'true' to append data to the file
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(name + "," + id + "," + password); // Save the data as a comma-separated string
                printWriter.close(); // Close the writer
                JOptionPane.showMessageDialog(null, "Cashier added successfully.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error saving cashier details.");
            }
        }
    }
}
