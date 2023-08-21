
public class Customer extends PersonDetails
{
    protected int phone;  // phone of the customer
    protected String company;  // company of the customer

    /**
     * Constructor
     * @param fn Full name
     * @param rn id number
     * @param em email
     * @param pn phone number
     * @param company
     */
    public Customer(String fn, int rn, String em, int pn, String c) {
        this.fullName = fn;
        this.idNumber = rn;
        this.email = em;

        this.phone = pn;
        this.company = c;
    }

    public int getTableNum() {
        return phone;
    }
    public void setTableNum(int tableNum) {
        this.phone = tableNum;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String c) {
        this.company = c;
    }

    /**
     * Get a description of this class as a String
     */
    @Override
    public String toString() {
        return "Customer - Name: " + fullName + " - Company: " + company;
    }
    /*
     * equals and hashcode methods to ensure that duplicate customers are NOT
     * added to the customer list.
     */
    @Override
    public boolean equals(Object obj)
    {
        return this.idNumber == ((Customer)(obj)).idNumber;
    }
    @Override
    public int hashCode()
    {
        return Integer.hashCode(this.idNumber);
    }

}
