
public class PersonDetails
{
    protected String fullName;
    protected int idNumber;
    protected String email;

    /*
     * Super Class for the Staff, Customer and Seller classes
     */
    public PersonDetails()
    {
        fullName = "";
        idNumber = 0;
        email = "";

    }

    // gets and sets
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fn) {
        this.fullName = fn;
    }
    public int getIdNumber(){
        return idNumber;
    }
    public void setIdNumber(int rn) {
        this.idNumber = rn;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String em) {
        this.email = em;
    }
}
