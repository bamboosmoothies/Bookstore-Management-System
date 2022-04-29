/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hachbrandonproject1;


/**
 *
 * @author School
 */
public class PremiumCustomer extends Customer{
    //Fields
    private boolean paymentDue;

    //Constructor
    public PremiumCustomer(int id, String firstName, String lastName, String paymentM, boolean paymentDue) {
        super(id, firstName, lastName, paymentM);
        this.paymentDue = paymentDue;
    }
    
    //Getter and Setter

    public boolean isPaymentDue() {
        return paymentDue;
    }

    public void setPaymentDue(boolean paymentDue) {
        this.paymentDue = paymentDue;
    }
    
    //Methods

    
}
