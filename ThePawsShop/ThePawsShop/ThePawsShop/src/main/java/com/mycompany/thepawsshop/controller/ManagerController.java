/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepawsshop.controller;

/**
 *
 * @author dhanu
 */
 

import com.mycompany.thepawsshop.model.Manager;

import javax.swing.JOptionPane;

public class ManagerController {
    public boolean registerManager(String username, String password, String confirmPassword) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Manager manager = new Manager(username, password);
        if (manager.saveToFile()) {
            JOptionPane.showMessageDialog(null, "Manager registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Error saving manager data", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}