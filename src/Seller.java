
public class Seller extends Staff{

    protected double salesTarget;
    protected Staff supervisor;
    protected String contractDate;
    protected String workShift;

    public Seller(String fn, int rn, String em, String c, String ws,double salesTarget, Staff supervisor) {
        super(fn, rn, em, c, ws);
        this.fullName = fn;
        this.idNumber = rn;
        this.email = em;
        this.contractDate = c;
        this.workShift = ws;

        this.salesTarget = salesTarget;
        this.supervisor = supervisor;
//		 TODO Auto-generated constructor stub
    }
//
//    public double getSalesTarget() {
//        return salesTarget;
//    }
//
//    public void setSalesTarget(double salesTarget) {
//        this.salesTarget = salesTarget;
//    }
//
//    public Staff getSupervisor() {
//        return supervisor;
//    }
//
//    public void setSupervisor(Staff supervisor) {
//        this.supervisor = supervisor;
//        PersonDetails C = new Seller(email, idNumber, email, salesTarget, supervisor);
//    }

    /*
     * toString method to print all attributes of the Seller class.
     */
    @Override
    public String toString() {
        return "Seller - Name : " + fullName + "Sales target: " + salesTarget + " Supervisor: " + supervisor;

    }

}
