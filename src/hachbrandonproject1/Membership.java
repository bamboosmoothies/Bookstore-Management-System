/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hachbrandonproject1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author School
 */
public class Membership {
    
    //Variable
    
    //ArrayList
    ArrayList<Customer> membership = new ArrayList<>(); 
    
    //Constructor
    public Membership()
    {   
        //populate 
        membership.add(new Customer(1, "Amy", "Grave", "1232"));
        membership.add(new Customer(2, "Carl", "Beef", "123123"));
        membership.add(new PremiumCustomer(3, "Henry", "Smell", "3123123123", true));
    }
    
    //Methods
    
    public void addPremiumMemberShip() throws InterruptedException {

        System.out.println("Enter your First Name.");
        Scanner addFirstName = new Scanner(System.in);
        String firstName = (addFirstName.nextLine());

        System.out.println("Enter your Last Name.");
        Scanner addLastName = new Scanner(System.in);
        String lastName = (addLastName.nextLine());

        Thread.sleep(1200); 
        System.out.println("Thank you for registering for the Premium Membership.");
        Thread.sleep(3000); 
        System.out.println("You will be billed upon $9.99 as of this month!");
        System.out.println("Enter your payment method to complete your registeration. Credit/Debit accepted!");

        Scanner paymentMethod = new Scanner(System.in);
        String paymentType = (paymentMethod.nextLine());
        
        int id = membership.get(membership.size() - 1 ).getId();
        id++;
        boolean paymentMonthly = true;
        
        membership.add(new PremiumCustomer(id, firstName, lastName, paymentType, paymentMonthly));
        
    }
    
    public void addFreeMembership() throws InterruptedException {
        
            System.out.println("Enter your First Name.");
            Scanner addFirstName = new Scanner(System.in);
            String firstName = (addFirstName.nextLine());

            System.out.println("Enter your Last Name.");
            Scanner addLastName = new Scanner(System.in);
            String lastName = (addLastName.nextLine());
            
            Thread.sleep(1200); 
            System.out.println("Thank you for registering!");
            Thread.sleep(3000); 
            System.out.println("Enter your payment method to complete your registeration. Credit/Debit accepted!");
            
            Scanner paymentMethod = new Scanner(System.in);
            String paymentType = (paymentMethod.nextLine());
            
            int id = membership.get(membership.size() - 1 ).getId();
            id++;
            
            membership.add(new Customer(id, firstName, lastName, paymentType));  
    }
    
    //Getters
    public ArrayList<Customer> getMembership() {
        return membership;
    }
    
    
    
    
    
}
