package hachbrandonproject1;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main  {
    /**
     * TODO:
     * Need to work on try-block for some reason it keeps looping back to the main menu at Case 2 and other.
     * @param args
     * @throws InterruptedException 
     */
    
   
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
    //Initialize Constructors
    Inventory inventory = new Inventory();
    Membership membership = new Membership();
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    Scanner scan = new Scanner(System.in);
    
    //Initalize ArrayLists for EndOfDayReport to collect and store data 
    ArrayList<String> trackPurchase = new ArrayList();
    ArrayList<String> trackNewMembers = new ArrayList(); 
    ArrayList<Integer> trackSales = new ArrayList();
    ArrayList<Double> trackRevenue = new ArrayList();
    
    
    boolean order = true;
    while(order == true) {
    try {
        
        //Tryblock to catch scan.nextInt() in Main Menu 

            System.out.println("Welcome to the Automated BookStore!");
            System.out.println("Select from one of the following option.");
            System.out.println("\t 1. Make a purchase.");
            System.out.println("\t 2. Register your account.");
            System.out.println("\t 3. Check what's for sale.");
            System.out.println("\t 4. Compare Products");
            System.out.println("\t 5. Restock a Product");
            System.out.println("\t 6. Check total value of inventory.");        
            System.out.println("\t 7. Exit.");
            int num = scan.nextInt();
            switch (num) {

                case 1:
                    //add code to add total items and cost
        try {
                double trackingOrderTotal = 0;
                double number = 0;
                int numberOfItem = 0;
                boolean loop = true;
                while (loop)
                {
                    try {  
                        System.out.println("Which of the following would you like to purchase?");
                        Thread.sleep(500);

                        //Get object details from productList
                        int label = 1;
                        for(int j = 0; j < inventory.productList.size(); j++)
                        {   
                            System.out.println("\t" + label + ". " + inventory.productList.get(j));
                            label++;
                        }  
                        int productID = scan.nextInt() - 1;
                        number = inventory.productList.get(productID).getCost();
                        //track today's Purchase
                        trackPurchase.add(inventory.productList.get(productID).outputProductFormatNoStock());
                        trackingOrderTotal += number;
                        
                    boolean loopa = true;
                    while ((loopa))
                    {
                        numberOfItem++;
                        System.out.println("You have " + numberOfItem + " item in cart. Are you ready to checkout? (Y/N)");
                        char letter = scan.next().charAt(0);

                            if (letter == 'Y' || letter == 'y'){
                                loop = false;
                                loopa = false;
                                inventory.decrementStock(productID);      
                                System.out.println("Thank-you for ordering!");
                                //output total item and cost                
                                System.out.println("Your total is ");
                                System.out.println("$" + numberFormat.format(trackingOrderTotal));
                                //track today's Sale
                                trackSales.add(numberOfItem);
                                //track today's Revenue
                                trackRevenue.add(trackingOrderTotal);

                                break;
                                }
                                //track total during loop
                                else if (letter == 'N' || letter == 'n'){
                                   loopa = false;
                                   System.out.println("$" + trackingOrderTotal);
                                   inventory.decrementStock(productID);
                                   
                                }
                                else
                                { 
                                    System.out.println("...");
                                    Thread.sleep(1500);
                                    System.out.println("Error: Misinput Detected.");
                                    Thread.sleep(1000);
                                    System.out.println("Enter (Y/N) and try again.");
                                    Thread.sleep(1000);
                                    numberOfItem--;
                                    //LOOP ERROR FOR SME 
                                }
                        }
                    }catch (InputMismatchException e)
                    {
                        System.out.println("...");
                        Thread.sleep(1000);
                        System.out.println("Error: The numberID you have entered does not exist.");
                        Thread.sleep(2000);
                        scan.nextLine();
                    }
                    catch (Exception e)
                    {
                        System.out.println("...");
                        Thread.sleep(1000);
                        System.out.println("Error: Misinput Detected. Please try again.");
                        Thread.sleep(2000);
                        scan.nextLine();
                    }
                    
                }
            
                        
                        //Code for member
                    //TODO : put try-catch block and while loop
                    boolean dookie = true;
                    while (dookie)
                    {
                        try {
                        Thread.sleep(500);                                         
                        System.out.println("Please select which member is making this purchase.");
                        Thread.sleep(500);   
                        System.out.println("\t 1. Find your membership");
                        System.out.println("\t 2. Continue as anonymous customer");
                        System.out.println("\t 3. Register as new member");
                        int num1 = scan.nextInt();
                        switch (num1) {

                            case 1:
                                //Populate membership from membership ArrayList
                                boolean dookie1 = true;
                                while (dookie1)
                                {
                                    try {
                                        System.out.println("Refreshing membership list...");
                                        Thread.sleep(1500);
                                        for(int j = 0; j < membership.membership.size(); j++)
                                        {   
                                            System.out.println("\t" + membership.membership.get(j).getId() + ". " 
                                                    + membership.membership.get(j).getFirstName() + " " 
                                                    + membership.membership.get(j).getLastName());
                                        }  

                                        System.out.println("");
                                        System.out.println("Enter your ID to proceed.");
                                        int numa = scan.nextInt() - 1;
                                        boolean dookie2 = true;
                                        while (dookie2)
                                        {
                                        System.out.println("Confirmed your account details" + "\n(Y/N)");
                                        System.out.println(membership.membership.get(numa));
                                            char letter = scan.next().charAt(0);
                                            if (letter == 'Y' || letter == 'y')
                                            {
                                                Thread.sleep(2500);                             
                                                System.out.println("Your total will be $" + numberFormat.format(trackingOrderTotal));
                                                orderProcessInfo(); 
                                                dookie = false;
                                                dookie1 = false;
                                                dookie2 = false;
                                                break;
                                            }
                                            else if (letter == 'N' || letter == 'n')
                                            {
                                                Thread.sleep(1000);
                                                System.out.println("Re-enter your numberID.");
                                                Thread.sleep(1500);
                                                dookie2 = false;
                                            }
                                            else 
                                            {
                                            System.out.println("...");
                                            Thread.sleep(500);
                                            System.out.println("Error: Misinput detected. Please try again.");
                                            Thread.sleep(1000);
                                            }
                                        }
                                    }catch (InputMismatchException e)
                                    {
                                        System.out.println("...");
                                        Thread.sleep(1000);
                                        System.out.println("Error: Misinput Detected. Please try again.");
                                        Thread.sleep(2000);
                                        scan.nextLine();
                                    }       
                                    catch (Exception e)
                                    {
                                        System.out.println("...");
                                        Thread.sleep(1000);
                                        System.out.println("Error: The numberID you have entered does not exist. Please try again.");
                                        Thread.sleep(2000);
                                        scan.nextLine();
                                    }
                                    //LEFT OFF
                                }
                                break;

                            case 2:
                                orderPaymentMethod();
                                orderProcessInfo();
                                dookie = false;
                                break;
                                
                            case 3:
                                //Tryblock
                                boolean case3 = true;
                                while (case3) 
                                {
                                    try {
                                            System.out.println("Let's get you registered as a new memeber!");
                                            System.out.println("Which membership would you like to register for?");
                                            System.out.println("\t 1. Free Membership"); 
                                            System.out.println("\t 2. Premium Membership"); 
                                            int num2 = scan.nextInt();

                                          switch (num2)
                                          {
                                                case 1:    
                                                    Thread.sleep(1000);
                                                    System.out.println("Your total will be $" + numberFormat.format(trackingOrderTotal) + "! Please complete your order to continue.");
                                                    Thread.sleep(2000);
                                                    membership.addFreeMembership();
                                                    Thread.sleep(2500); 
                                                    System.out.println("Thank you for registering!"); 
                                                    orderProcessInfo();
                                                    //Track Members for Today
                                                    trackNewMembers.add(membership.membership.get(membership.membership.size()- 1).toString());
                                                    Thread.sleep(500);
                                                    case3 = false;
                                                    dookie = false;
                                                    break;

                                                case 2:                         
                                                    System.out.println("Premium Membership is $9.99.");
                                                    Thread.sleep(1000);
                                                    double totalSum1 = trackingOrderTotal + 9.99;
                                                    System.out.println("Your new total will be $" + numberFormat.format(totalSum1) + " with your Premium membership included!");
                                                    Thread.sleep(2000); 
                                                    membership.addPremiumMemberShip();
                                                    Thread.sleep(2500); 
                                                    System.out.println("Thank you for registering!"); 
                                                    orderProcessInfo();
                                                    //Track Members for Today
                                                    trackNewMembers.add(membership.membership.get(membership.membership.size()- 1).toString());
                                                    Thread.sleep(500);
                                                    case3 = false;
                                                    dookie = false;
                                                    break;
                                                } // switch          
                                            } catch (Exception e)
                                            {
                                                System.out.println("...");
                                                Thread.sleep(1000);
                                                System.out.println("Error: Misinput Detected. Please try again.");
                                                Thread.sleep(2000);
                                                scan.nextLine();
                                            }
                                        } //while loop
                                    } // switch member
                                } catch (Exception e)
                                {
                                    System.out.println("...");
                                    Thread.sleep(1000);
                                    System.out.println("Error: Misinput Detected. Please try again.");
                                    Thread.sleep(2000);
                                    scan.nextLine();
                                }
                                } //while loop dookie
                    }catch (InputMismatchException e)
                    {
                        System.out.println("...");
                        Thread.sleep(1000);
                        System.out.println("Error: Misinput Detected. Please try again.");
                        Thread.sleep(2000);
                        scan.nextLine();
                    }
                    catch (Exception e)
                    {
                        System.out.println("...");
                        Thread.sleep(1000);
                        System.out.println("Error. Please try again.");
                        Thread.sleep(2000);
                        scan.nextLine();
                    } 
                        break;
                        
//Separated from Case 1 member switch case 
//This is case 2 of the main switch
                case 2:
                    //TRY loop to recall this case block 
                    boolean case2 = true;
                    while(case2)
                    {
                        System.out.println("Let's get you registed as a new memeber!");
                        System.out.println("Which membership would you like to register for?");
                        System.out.println("\t 1. Free Membership"); 
                        System.out.println("\t 2. Premium Membership"); 
                        //Try catch block
                        try {
                            int num2 = scan.nextInt();
                            switch (num2)
                                {
                                case 1:
                                    //Tryblock already implemented in method on line 190
                                    membership.addFreeMembership();;
                                    orderRegisterInfo();
                                    Thread.sleep(500);
                                    //Track Members for Today
                                    trackNewMembers.add(membership.membership.get(membership.membership.size() - 1).toString());
                                    case2 = false;
                                    break;
                                case 2:
                                    //Tryblock already implemented in method on line 197
                                    membership.addPremiumMemberShip();
                                    orderRegisterInfo();
                                    Thread.sleep(500);
                                    //Track Members for Today                                
                                    trackNewMembers.add(membership.membership.get(membership.membership.size() - 1).toString());
                                    case2 = false;
                                    break;
                                default:
                                    System.out.println("Sorry, but you need to enter a 1 or 2.");
                                    Thread.sleep(1000);
                                }
                            } catch (InputMismatchException e)
                                {
                                    System.out.println("...");
                                    Thread.sleep(1000);
                                    System.out.println("Error: Enter number 1-2 Only.");
                                    Thread.sleep(2500);
                                    scan.nextLine();
                                }
                                catch (Exception e)
                                {
                                    System.out.println("...");
                                    Thread.sleep(1000);
                                    System.out.println("Error: ");
                                    Thread.sleep(2500);
                                    scan.nextLine();
                                }
                    }
                    break;

                case 3:
                    //Return order Info
                        System.out.println("Here are the product we have for sale in our inventory!");
                        Thread.sleep(1000);
                        int label = 1;
                        for(int j = 0; j < inventory.productList.size(); j++)
                        {   
                            System.out.println("\t" + label + ". " + inventory.productList.get(j));
                            label++;
                        }  
                        Thread.sleep(8000);
                        System.out.println("Returning back to the main menu");
                        Thread.sleep(5000);

                    break;   

                case 4:
                        inventory.compareItems();     
                    break;

                case 5:
                    boolean cont = true;
                    while (cont)
                    {
                        try { //tryblock here
                        System.out.println("What product would you like to restock?");
                        int labell = 1;
                        for(int j = 0; j < inventory.productList.size(); j++)
                        {   
                            System.out.println("\t" + labell + ". " + inventory.productList.get(j));
                            labell++;                                    
                        }
                        
                        int userInput = scan.nextInt() - 1;
                            System.out.println("What would you like to set the stock to?");
                            int userInput2 = scan.nextInt();
                            inventory.restockProduct(userInput, userInput2);
                            System.out.println(inventory.productList.get(userInput));
                            Thread.sleep(500);
                            System.out.println("UPDATED STATUS == COMPLETED");
                            Thread.sleep(1000);
                            cont = false;
                        } catch (InputMismatchException e) 
                            {
                                System.out.println("...");
                                Thread.sleep(1500);
                                System.out.println("Error: The number ID you have enter is invalid.");
                                Thread.sleep(2000);
                                System.out.println("Please try again.");
                                Thread.sleep(1500);
                                scan.nextLine();
                            }
                            catch (Exception e)
                            {
                                System.out.println("...");
                                Thread.sleep(1000);
                                System.out.println("Error: The number ID you have enter does not exist.");
                                Thread.sleep(2000);
                                System.out.println("Please try again.");
                                Thread.sleep(1500);
                                scan.nextLine();
                            }
                            }                            
                    break;

                case 6:
                    //check total value of inventory
                    double inventoryValue = inventory.inventoryValue();             
                    System.out.println("Total inventory value: $" + numberFormat.format(inventoryValue));
                    Thread.sleep(1000);
                    System.out.println("Returning back to the main menu");
                    Thread.sleep(2000);          
                    break;  

                case 7:
                    System.out.println("Exiting.");
                    inventory.outputEndOfDayReport(trackPurchase, trackNewMembers, trackSales, trackRevenue);
                    inventory.outputUpdatedInventory();
                    order = false;
                    break;                 

                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3, 4, 5, 6, 7");                   
        } // main switch case 
        } catch (Exception e)
        {
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("Error: Misinput Detected. Please try again.");
            Thread.sleep(2000);
            scan.nextLine();
        }
    } //while order = true
    
} //main method
    
    
    
    //Methods
    
        //This method basically prints out a generic order process and a thank you.
        public static void orderProcessInfo() throws InterruptedException{
            Thread.sleep(1000);  
            System.out.println("Your order is processing.");
            Thread.sleep(2000);  
            System.out.println("Order Processed!");
            Thread.sleep(500);  
            System.out.println("Thank-you for ordering!");
            Thread.sleep(1800); 
            System.out.println("Now returning to the main menu");
            Thread.sleep(4000);
        }
        public static void orderRegisterInfo() throws InterruptedException{
            Thread.sleep(1000);  
            System.out.println("Your registeration is processing.");
            Thread.sleep(2000);  
            System.out.println("Registeration complete!");
            Thread.sleep(1100);  
            System.out.println("Thank-you for registering!");
            Thread.sleep(2500); 
            System.out.println("Now returning to the main menu");
            Thread.sleep(4000);
        }
        
        //Anonymous Customers, no paymentType save necessary 
        public static void orderPaymentMethod() throws InterruptedException{
            Thread.sleep(500);
            System.out.println("Enter your payment method to complete your order. Credit/Debit accepted!");
            Scanner paymentMethod = new Scanner(System.in);
            String paymentType = (paymentMethod.nextLine());
        }
        
        
       
}
