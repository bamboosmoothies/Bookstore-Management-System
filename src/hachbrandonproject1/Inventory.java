/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hachbrandonproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author School
 */
public class Inventory implements BookstoreSpecification {
     /**
     * Contains method for .csv input and output
     * If .txt or .csv missing from project file manager,
     * please check this project file directory by using 
     * Window file explorer or Mac file explorer 
     * @param args
     */
    
    //Initialize 
    ArrayList<Product> productList = new ArrayList<>();
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    
    // Object(id, # of stock, price, type , title, author) 
    public Inventory () throws FileNotFoundException 
    {   
        populateInventoryFromFile("BookInventory.csv");
    }
    
    public void compareItems() throws InterruptedException {
        Collections.sort(productList);
        
        for (Product product : productList)
        {
            System.out.println("Name: " + product.getTitle() + "\n\t Price: $" + product.getCost());
        }
        
        Thread.sleep(2000);
        System.out.println("Returning back to the main menu.");
        Thread.sleep(3500);
    }
    
    public void decrementStock(int productId) throws InterruptedException
    {
        int decrement = productList.get(productId).getStock();
        if (decrement > 1)
        {
            productList.get(productId).setStock(decrement - 1); 
        }
        else 
        {
            System.out.println(productList.get(productId).getTitle() + " is now out of stock!");
            Thread.sleep(3000);
            System.out.println("Refreshing and updating inventory status!");
            Thread.sleep(5000);
            productList.remove(productId);
        }

    }
    
    public void populateInventoryFromFile(String fileName) throws FileNotFoundException
    {
        try {
            File fileNames = new File(fileName);

            if (fileNames.canRead()) 
            {

                //get Scanner on file
                Scanner fileScanner = new Scanner(fileNames);

                
                //sentinel loop on hasNext
                while (fileScanner.hasNextLine())
                {

                    //Setup
                    String line = fileScanner.nextLine();
                    String[] items = line.split(",");

                    //put all of these into Student Object
                    
                    String sId = items[0];
                    String type = items[1];
                    String title = items[2];
                    String author = items[3];
                    String sStock = items[4];
                    String sPrice = items[5];
                    
                    if((!(items[0].equals("productID"))) 
                    && (!(items[1].equals("type"))) 
                    && (!(items[2].equals("title"))) 
                    && (!(items[3].equals("author/artist"))) 
                    && (!(items[4].equals("numInStock"))) 
                    && (!(items[5].equals("price"))) )
                    {
                        //Reconfig String 
                        int id = Integer.parseInt(sId);
                        int stock = Integer.parseInt(sStock);
                        double price = Double.parseDouble(sPrice);
   
                        
                        //create object based by type of product.

                        if ( (items[1].equals("book")) ) 
                        {
                            productList.add(new Books(id, stock, price, type, title, author));       
                        }
                        if ( (items[1].equals("cd")) ) 
                        {
                            productList.add(new CDs(id, stock, price, type, title, author));
                        }
                        if ( (items[1].equals("dvd")) ) 
                        {
                            productList.add(new DVDs(id, stock, price, type, title, author));
                        }

                    }                 
                }
            }
   
        } catch (FileNotFoundException ex) {
            System.out.println("Caught FileNotFoundException for BookInventory.csv Try again making sure the file name and path are correct.");
        }
    }
    
    public void outputEndOfDayReport(ArrayList<String> trackPurchase, ArrayList<String> trackNewMembers, ArrayList<Integer> trackSales, ArrayList<Double> trackRevenue)
    {
        FileOutputStream fs;
        try {
            //File Directory
            fs = new FileOutputStream("endOfDayReport.txt");
            PrintWriter outFS = new PrintWriter(fs);

            outFS.println("Today's List of Purchases");
            {
                for (int i = 0; i < trackPurchase.size(); i++)
                {
                    outFS.println("\t" + trackPurchase.get(i));
                }
            }
            outFS.println("Today's List of New Members");
            {
                for (int i = 0; i < trackNewMembers.size(); i++)
                {
                    outFS.println("\t" + trackNewMembers.get(i));
                }
            }
            outFS.println("Today's Total Sales and Revenue");
            {
                    DecimalFormat numberFormat = new DecimalFormat("#.00");
                    int totalSales = 0;
                    for (int i = 0; i < trackRevenue.size(); i++)
                    {
                        totalSales += trackSales.get(i);
                    }
                    outFS.println("\tTotal Sales: " + totalSales);

                    double totalRevenue = 0;
                    for (int i = 0; i < trackRevenue.size(); i++)
                    {
                        totalRevenue += (trackRevenue.get(i));
                    }        
                    outFS.println("\tTotal Revenue: $" + numberFormat.format((totalRevenue)));
            }

            outFS.close();
            fs.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Caught FileNotFoundException for endOfDayReport.txt. Try again making sure the file name and path are correct.");
        } catch (IOException ex) {
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
    }
    
    public void outputUpdatedInventory()
    {
        FileOutputStream fs;
        try {
            //File Directory
            fs = new FileOutputStream("BookInventoryUpdated.csv");
            PrintWriter outFS = new PrintWriter(fs);
            {
                
                outFS.println("productID,type,title,author/artist,numInStock,price");
                
                for(int i = 0; i < productList.size(); i++)
                {
                    outFS.println(productList.get(i).outputProductFormat());
                }
                
            }
            outFS.close();
            fs.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Caught FileNotFoundException for outputData.txt. Try again making sure the file name and path are correct.");
        } catch (IOException ex) {
            System.out.println("Caught IOException when closing output stream. Try again.");
        }
    }
    
    @Override
    public int restockProduct(int productId, int amount) {
        
        productList.get(productId).setStock(amount);
        return 0;
        
    }

    @Override
    public double inventoryValue() {
        
        double total = 0;
        
        for (Product i : productList)
        {
            total += (i.getStock() * i.getCost());
        }
        
        return total;
    }
    
    

    
    
    

    
}
