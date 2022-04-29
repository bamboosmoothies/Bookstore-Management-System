/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hachbrandonproject1;

import java.io.FileNotFoundException;

/**
 *
 * @author School
 */
public class TestHarness {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Inventory inventory = new Inventory();
        //test if read from .csv file
//        inventory.populateInventoryFromFile("BookInventory1.csv");
        //test if object is created from .csv file 
        System.out.println(inventory.productList);
    }
    
}
