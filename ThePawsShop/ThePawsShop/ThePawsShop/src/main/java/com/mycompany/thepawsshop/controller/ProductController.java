/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.thepawsshop.controller;
/**
 *
 * @author dhanu
 */
 

import com.mycompany.thepawsshop.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {

    // File where products are stored
    private List<Product> products;
    private final String filePath = "products.txt"; 

    public ProductController() {
        products = new ArrayList<>();
        loadProductsFromFile();
    }

    
 /*To Get all the products commenced by the Add Button*/
    
    public List<Product> getAllProducts() {
        return products;
    }
    
    
    /*This to seach by category and this is done using the Search Button*/

    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }
        return result;
    }

    /*To add the products to the array list called product by the Add button*/
    
    public void addProduct(Product product) {
        products.add(product);
        saveProductsToFile();  // Save the product to file after adding
    }

    /*To view the products*/
    
    private void loadProductsFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] productData = line.split(",");
                if (productData.length == 4) {
                    String id = productData[0];
                    String name = productData[1];
                    String category = productData[2];
                    double price = Double.parseDouble(productData[3]);
                    Product product = new Product(id, name, category, price);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }
/*To save the products from the product file to products.txt*/
    
    private void saveProductsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Product product : products) {
                bw.write(product.getId() + "," + product.getName() + "," + product.getCategory() + "," + product.getPrice());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }
}
