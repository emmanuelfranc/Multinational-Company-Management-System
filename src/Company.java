import java.util.ArrayList;

/**
 * A class that associates the current company, the list of customers (stored as a Binary Tree), and a list of employees.
 *
 * ATTENTION: You do NOT need to modify this code at all.
 *
 */
public class Company
{
    private int code;  // internal code of the company, eg. 565
    private String name; // name of the company / branch
    private BinaryTree btree; // binary tree that stores the customers
    private ArrayList<Staff> employees; // List of employees of this company / branch

    /**
     * Constructor
     * @param c code
     * @param n name
     */
    public Company(int c, String n) {
        this.code = c;
        this.name = n;
        this.btree = new BinaryTree(); // empty
        this.employees = new ArrayList<Staff>();  // empty
    }
    /**
     * Constructor
     * @param c code
     * @param n name
     * @param bt Binary tree
     * @param e employees
     */
    public Company(int c, String n, BinaryTree bt, ArrayList<Staff> e) {
        this.code = c;
        this.name = n;
        this.btree = bt; // empty
        this.employees = e;
    }

    // getters and setters!
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BinaryTree getBtree() {
        return btree;
    }
    public void setBtree(BinaryTree btree) {
        this.btree = btree;
    }
    public ArrayList<Staff> getEmployees() {
        return employees;
    }
    public void setEmployees(ArrayList<Staff> employees) {
        this.employees = employees;
    }

    /**
     * Add a Customer to the binary tree
     * @param s The customer
     */
    public void addCustomer(Customer s)
    {
        btree.addNode(s);
    }
    /**
     * Add a Employee
     * @param s The new employee
     */
    public void addEmployee(Staff s)
    {
        employees.add(s);
    }

    /**
     * Walk tree method
     * @return A String with the names of all Customer in the tree
     */
    public String walkTree()
    {
        return btree.walkTree();
    }

    /**
     * Find a customer in the binary tree using the name
     * @param name The name of the customer you are searching for
     * @return A reference to the Customer that was found or null if no Customer found
     */
    public Customer find(String name)
    {
        return btree.find(name);
    }

    /**
     * Method for printing the tree
     */
    public void describeStudentTree()
    {
        btree.printTree();
    }

    /**
     * Get a description of the Module as a String
     */
    public String toString() {
        return "Company: " + code + " - " + name;
    }
    /*
     * Methods created to aid the merge sort in comparison
     * Although these methods are not mandatory to carry out to the sort -given that the methods above can be used,
     *  I created these ones because I tend to understand better what is going on behind the codes.
     */

    /* Is less than method helps sort the companies by their codes
     *
     */
    public boolean isLessThan(Company that) {
        if (code < that.code) return true;
        else if (code > that.code) return false;
        return true;

    }
    // The method below helps sorts the companies according to their names.
    public boolean compareToIgnoreCase(Company str) {
        if (name.compareTo(str.name)>0)return true;
        else if (name.compareTo(str.name) < 0) return false;
        return true;
    }
}
