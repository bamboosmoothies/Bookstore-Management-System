package hachbrandonproject1;

import java.util.ArrayList;

public abstract class Product implements Comparable<Product> {
    //Fields
    private int id;
    private int stock;
    private double cost;
    private String type;
    private String title;
    private String author;
    
    
    //ArrayList Inventory which contains product, product cost, and product type 
    ArrayList<Product> inventory = new ArrayList<>(); 
 
    //Constructor
    public Product(int id, int stock, double cProduct, String type, String title, String author){
        this.id = id;
        this.stock = stock;
        this.cost = cProduct;
        this.type = type;
        this.title = title;
        this.author = author;
    }

    
    //Getter and Setter
    public ArrayList<Product> getInventory() {
        return inventory;
    }

    public int getStock() {
        return stock;
    }
    
    public String getType() {
        return type;
    }
    

    public double getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return this.author = author;
    }
    public int getId() {
        return id;
    }
    
    

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Methods
    
    public String outputProductFormat() 
    {
        //Reformat product for .csv 
        //productID,type,title,author/artist,numInStock,price
        return  id + "," + type + "," + title + "," + author + "," + stock + "," + cost;
    }
    
    public String outputProductFormatNoStock()
    {
        return title + ", " + "by " + author + ", " + type + ", $" + cost;
    }
    
    @Override
    public String toString() {
        return title + ", " + "by " + author + ", " + type + ", $" + cost + ", " + "Stock: " + stock;
    }

    @Override
    public int compareTo(Product o) {
        Product other = (Product) o;
        
        if (this.getCost() > other.getCost()) 
        {
            return 1;
        }
         
        if (this.getCost() < other.getCost()) 
        {
            return -1;
        }
        else return 0;
    }
    


    
    
    
    
    
    
    
    
    
    
}


