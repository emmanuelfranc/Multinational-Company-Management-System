import java.util.ArrayList;

public class Staff extends PersonDetails {
    protected static int MAX_NUM_CUSTOMERS = 3; // maximum number of clients that a employee can be responsible for

    protected String contract_date; // this is the date in which the staff has been hired
    protected String work_shift; // work shit - 00-08 or 08-16 or 16-00

    //Customer list to store the current customers
    protected ArrayList<Customer> customerList = new ArrayList<Customer>();
    protected boolean canDoubleShift;

    /**
     * Constructor
     *
     * @param fn Full Name
     * @param rn id Number
     * @param em Email
     * @param c  Contract date
     * @param ws Work shift
     */

    public Staff(String fn, int rn, String em, String c, String ws) {
        this.fullName = fn;
        this.idNumber = rn;
        this.email = em;

        this.contract_date = c;
        this.work_shift = ws;

    }
    //New constructor for staff with all parameters
    public Staff(String fn, int rn, String em, String c, String ws, boolean canDoubleShift, ArrayList<Customer> CustomerList) {
        this.canDoubleShift = canDoubleShift;
        this.customerList = new ArrayList<Customer>();
    }

    public String getContractDate() {
        return contract_date;
    }

    public void setContractDate(String cd) {
        this.contract_date = cd;
    }

    public String getWork_shift() {
        return work_shift;
    }

    public void setWork_shift(String work_shift) {
        this.work_shift = work_shift;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean isCanDoubleShift() {
        if (canDoubleShift) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Add a new customer to the list of customers of the employee
     *
     * @param d -The new customer to be added
     * @return true if the customer was added successfully
     */
    public boolean addCustomer(Customer d) {
        // Only add customers if the customer list has not exceeded the max and if customer is not already contained in the list.
        if (customerList.size() < MAX_NUM_CUSTOMERS && !customerList.contains(d)) {
            customerList.add(d);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove a customer of the list of customers of the employee
     *
     * @return true if the customer was removed successfully
     */
    public boolean removeCustomer(Customer d) {
        //First check that customer list is not empty and the customer to be removed is contained in the list.
        if (customerList != null && customerList.contains(d)) {
            customerList.remove(d);
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "Staff: " + fullName;
    }

}
