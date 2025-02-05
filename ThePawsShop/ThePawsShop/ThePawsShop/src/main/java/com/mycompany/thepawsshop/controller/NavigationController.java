package com.mycompany.thepawsshop.controller;

/**
 *
 * @author dhanu
 */
 

import com.mycompany.thepawsshop.view.ManagerVerificationForm;
import com.mycompany.thepawsshop.view.RoleSelectionForm;
import com.mycompany.thepawsshop.view.CashierLoginForm; // Assuming you have this form as well
import com.mycompany.thepawsshop.view.ManagerRegistrationForm; // Assuming this form is available

/**
 * This class handles navigation between different forms in the application.
 */

public class NavigationController {
    
    // Method to navigate to ManagerVerificationForm from RoleSelectionForm
    public void openManagerVerificationForm(javax.swing.JFrame currentForm) {
        // Hide the current form
        currentForm.setVisible(false);
        
        // Create and show the ManagerVerificationForm
        ManagerVerificationForm managerForm = new ManagerVerificationForm();
        managerForm.setVisible(true);
    }
    
    // Method to navigate to Cashier Login Form (example for Cashier button)
    public void openCashierLoginForm(javax.swing.JFrame currentForm) {
        // Hide the current form
    currentForm.setVisible(false);
    
    // Create and show the CashierLoginForm (assuming you have this form)
    CashierLoginForm cashierLoginForm = new CashierLoginForm();
    cashierLoginForm.setVisible(true);
    }

    // Method to navigate to Manager Registration Form
    public void openManagerRegistrationForm(javax.swing.JFrame currentForm) {
        // Hide the current form
        currentForm.setVisible(false);
        
        // Create and show the ManagerRegistrationForm
        ManagerRegistrationForm managerRegistrationForm = new ManagerRegistrationForm();
        managerRegistrationForm.setVisible(true);
    }
    
    // Method to handle RoleSelectionForm navigation to ManagerVerificationForm
    public void openManagerVerificationFromRoleSelectionForm(RoleSelectionForm roleSelectionForm) {
        roleSelectionForm.setVisible(false); // Hide RoleSelectionForm
        ManagerVerificationForm managerVerificationForm = new ManagerVerificationForm();
        managerVerificationForm.setVisible(true); // Show ManagerVerificationForm
    }
}
