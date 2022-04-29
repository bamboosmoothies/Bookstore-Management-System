package hachbrandonproject1;


public class Customer {
    //Fields
    private int id;
    private String firstName;
    private String lastName;
    private String paymentMethod;
    //Constructor
    public Customer(int id, String firstName, String lastName, String paymentMethod){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.paymentMethod = paymentMethod;
    }
    
    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Method

    @Override
    public String toString() {
        return "\t" + id + ". " + firstName + " " + lastName;
    }
}
