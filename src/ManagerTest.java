import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides different methods of checking the behaviour
 * of the MultinationalManager class and the objects that it uses. It maintains a
 * reference to a MultinationalManager object called 'manager' and populates it via
 * the loadData method.
 *
 * If you run this class via a call to main, main will create
 * a MultinationalManager object and call the go method which produces some useful output that
 * you can analyse.
 *
 * Once you implement the unit test, you should run this code as a JUnit test.
 *
 */
public class ManagerTest {
    MultinationalManager manager = new MultinationalManager();
    BinaryTree tree = new BinaryTree();


    public static void main(String[] args) {
        ManagerTest test = new ManagerTest();
        test.go();
    }

    @Before
    public void loadData() {
        class Tuple<X, Y> {
            public final X x;
            public final Y y;
            public Tuple(X x, Y y) {
                this.x = x;
                this.y = y;
            }
        }
        manager.clear();

        Staff[] employee_list = new Staff[]{ new Staff("Alek Sib", 159, "aleksib@multi.ac.uk", "2/2019", "8-16"),
                new Staff("Jill Lai", 369, "jl@multi.ac.uk", "1/2015", "16-00"),
                new Staff("Kevin Jack", 789, "kj@multi.ac.uk", "2/2022", "08-16"),
                new Staff("Guy F", 654, "gf@multi.ac.uk", "1/2022", "00-08"),
                new Staff("Loius V", 643, "lv@multi.ac.uk", "2/2016", "08-16"),
                new Staff("Lett A", 580, "la@multi.ac.uk", "2/2019", "00-08"),
                new Staff("Stephanie A", 999, "sa@multi.ac.uk", "1/2021", "8-16"),
                new Staff("A Livia", 345, "al@multi.ac.uk", "1/2015", "00-08"),
                new Staff("John Jack A", 734, "jj@multi.ac.uk", "2/2016", "16-00"),
                new Staff("Loius Q", 684, "lq@multi.ac.uk", "1/2017", "8-16"),
                new Staff("Mattie K", 417, "mk@multi.ac.uk", "1/2014", "00-08"),
                new Staff("Claudia A", 310, "ca@multi.ac.uk", "2/2013", "16-00"),
                new Staff("Bianca B", 927, "bb@multi.ac.uk", "1/2021", "8-16"),
                new Staff("Alexander O", 183, "ao@multi.ac.uk", "1/2012", "00-08"),
                new Staff("Duncan D", 37, "dd@multi.ac.uk", "2/2010", "16-00"),
                new Staff("Is Cra Po", 75, "ic@multi.ac.uk", "2/2010", "8-16"),
                new Staff("Nikki Jinn", 99, "nj@multi.ac.uk", "2/2011", "16-00"),
        };

        Customer[] customer_list = new Customer[]{
                new Customer("John J", 147, "jj@multi.ac.uk", 999999, "Apple"),
                new Customer("Kate K", 565, "kk@multi.ac.uk", 0746025, "MS"),
                new Customer("Loius L", 6542, "ll@multi.ac.uk", 999999, "SMT"),
                new Customer("Zhang Z", 805, "zz@multi.ac.uk", 999999, "NXS"),
                new Customer("Xing L", 100, "xl@multi.ac.uk", 999999, "Fercis Ltd"),
                new Customer("Alma A", 753, "aa@multi.ac.uk", 999999, "Korr Supermarkets"),
                new Customer("Borba B", 888, "bb@multi.ac.uk", 999999, "Zelu Apps"),
                new Customer("Zeus L", 001, "zl@multi.ac.uk", 999999, "123 Travels"),
                new Customer("Laura Q", 075, "lq@multi.ac.uk", 999999, "Moment Capturer"),
                new Customer("Pierre A", 130, "pa@multi.ac.uk", 999999, "LL"),
                new Customer("Jess Z", 010, "jz@multi.ac.uk", 999999, "QPA"),
                new Customer("Hugh J", 101, "hj@multi.ac.uk", 999999, "RS passe"),
                new Customer("Paul P", 654, "pp@multi.ac.uk", 999999, "Posh Cpn")}; // include here some MSc Students

        Company branch1 = new Company(147, "All Materials Ldt", new BinaryTree(new Customer[]{customer_list[0], customer_list[10], customer_list[1], customer_list[5]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[0], employee_list[1])));
        Company branch2 = new Company(199, "Everything Plus Plus", new BinaryTree(new Customer[]{customer_list[2], customer_list[12]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[2])));
        Company branch3 = new Company(201, "LIKA", new BinaryTree(new Customer[]{customer_list[1], customer_list[2], customer_list[3]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[3])));
        Company branch4 = new Company(250, "OCCAM", new BinaryTree(new Customer[]{customer_list[4], customer_list[5], customer_list[6], customer_list[7]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[4], employee_list[5])));
        Company branch5 = new Company(101, "All Materials - NY Branch", new BinaryTree(new Customer[]{customer_list[7], customer_list[8], customer_list[9]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[6], employee_list[7])));
        Company branch6 = new Company(301, "All Materials - EU Branch", new BinaryTree(new Customer[]{customer_list[0], customer_list[1]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[8])));
        Company branch7 = new Company(401, "OCCAM Brazil", new BinaryTree(new Customer[]{customer_list[4], customer_list[11]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[9], employee_list[10])));
        Company branch8 = new Company(450, "LIKA Mobile", new BinaryTree(new Customer[]{customer_list[11], customer_list[12]}),
                new ArrayList<Staff>(Arrays.asList(employee_list[11], employee_list[12])));

        manager.addCompany(branch1);
        manager.addCompany(branch2);
        manager.addCompany(branch3);
        manager.addCompany(branch4);
        manager.addCompany(branch5);
        manager.addCompany(branch6);
        manager.addCompany(branch7);
        manager.addCompany(branch8);

		Company branch9 = new Company(475, "Everything++ Japan", new BinaryTree(new Customer[]{customer_list[4], customer_list[2]}),
				new ArrayList<Staff>(Arrays.asList(employee_list[13], employee_list[14],
						new Seller("New Guy", 777, "ng@multi.ac.uk", "2/2022", "16-00", 125, employee_list[14]))));
		Company branch10 = new Company(501, "GG WP", new BinaryTree(new Customer[]{customer_list[6], customer_list[10], customer_list[12]}),
				new ArrayList<Staff>(Arrays.asList(employee_list[15], employee_list[15],
						new Seller("Lin Li", 1405, "lli@multi.ac.uk", "2/2021", "00-08", 147, employee_list[13]),
						new Seller("Akone A", 955, "aas@multi.ac.uk", "1/2020", "08-16", 85, employee_list[11]))));

		manager.addCompany(branch9);
		manager.addCompany(branch10);

        // feel free to include more relationships
        ArrayList<Tuple> rel = new ArrayList<Tuple>(Arrays.asList(new Tuple(0,1), new Tuple(3,0),
                new Tuple(5,0), new Tuple(7,3), new Tuple(2,4), new Tuple(4,6)));
        for (Tuple t : rel) {
            manager.addRelationship(manager.getCompanies().get((int)t.x), manager.getCompanies().get((int)t.y));
        }
    }

    /**
     * Print the contents of the ArrayList 'list' to standard output.
     * @param list The list to print
     */
    public void printArrayList(ArrayList<Company> list) {
        for (Company v:list)
            System.out.println(v.toString());
    }

    /**
     * 'go' produces a useful set of output that allows you to see the
     * initial state of the attributes, the results of doing the
     * tree walk, an attempt at finding an object in the tree and
     * the results of doing a graph search, a merge sort, and a binary search. Initially,
     * only the state of the modules list will be correct. As you add
     * further functionality, you should see the correct output being
     * printed via this method. You do not need to modify it but you may
     * want to add your own checks to confirm your code is working as intended.
     */
    public void go() {
        loadData();
        System.out.println("--Company List--");
        manager.describeCompanies();
        System.out.println();

        System.out.println("\n--Tree Walk--\n" + manager.walkTree(3));

        System.out.println("\n--Find--");
        Customer mf = manager.find(0, "Alma A"); // should be found
        if (mf != null)
            System.out.println("Found: " + mf);
        else
            System.out.println("Could not find Alma A");

        Customer aw = manager.find(1, "J Jackson"); // should not be found
        if (aw != null)
            System.out.println("Found: " + aw);
        else
            System.out.println("Could not find J Jackson");


        System.out.println("\n--Sort asceding name--");
        ArrayList<Company> sorted;
        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = manager.mergeSort(true, "name");
        printArrayList(sorted);

        System.out.println("\n--Sort desceding code--");
        // Reload the data, otherwise it will still be sorted...
        loadData();
        sorted = manager.mergeSort(false, "code");
        printArrayList(sorted);

        System.out.println("\n--Connection Search--");
        if (manager.isConnected(manager.getCompanies().get(7), manager.getCompanies().get(5))) {
            System.out.println("Two nodes are connected"); // this should be connected
        } else {
            System.out.println("Two nodes are NOT connected");
        }

        if (manager.isConnected(manager.getCompanies().get(7), manager.getCompanies().get(2))) {
            System.out.println("Two nodes are connected");
        } else {
            System.out.println("Two nodes are NOT connected"); // this should NOT be connected
        }
    }

    /**
     * A test for the walk
     */
    @Test
    public void walkTest() {
        String expected = "Xing L," +"Alma A," +"Zeus L,"+"Borba B,"; //A String concatenation of the nodes expected to be visited.

        assertEquals ("Tree walk failed: ", expected, manager.walkTree(3));
    }



    /**
     * A test for the find method
     */
    @Test
    public void findTest() {
        Customer mf = manager.find(0, "Alma A");
        Customer aw = manager.find(1, "J Jackson");

        String mfExpected = "Alma A";
        String awExpected = null; //Since 'J Jackson' cannot be found, the expected is null.

        assertEquals ("Find test failed: ",mfExpected,mf.getFullName());
        assertEquals("Find test failed: ", awExpected, aw);
    }

    /**
     * A test for the sorting method
     */
    @Test
    public void sortingTest() {
        ArrayList<Company> sortedNames = manager.mergeSort(true, "name");
        ArrayList<Company> sortedCodes = manager.mergeSort(false, "code");

        //Store both the expected names and codes in ArrayLists of String to make them comparable to the ArrayList of company which contains the sorted ones.
        ArrayList<String> expectedNames =  new ArrayList<>();
        expectedNames.add("Company: 301 - All Materials - EU Branch");
        expectedNames.add("Company: 101 - All Materials - NY Branch");
        expectedNames.add("Company: 147 - All Materials Ldt");
        expectedNames.add("Company: 199 - Everything Plus Plus");
        expectedNames.add("Company: 201 - LIKA");
        expectedNames.add("Company: 450 - LIKA Mobile");
        expectedNames.add("Company: 250 - OCCAM");
        expectedNames.add("Company: 401 - OCCAM Brazil");

        ArrayList<String> expectedCodes = new ArrayList<>();
        expectedCodes.add("Company: 450 - LIKA Mobile");
        expectedCodes.add("Company: 401 - OCCAM Brazil");
        expectedCodes.add("Company: 301 - All Materials - EU Branch");
        expectedCodes.add("Company: 250 - OCCAM");
        expectedCodes.add("Company: 201 - LIKA");
        expectedCodes.add("Company: 199 - Everything Plus Plus");
        expectedCodes.add("Company: 147 - All Materials Ldt");
        expectedCodes.add("Company: 101 - All Materials - NY Branch");

        //They are both converted to Strings in order to have the same types in the comparison.
        assertEquals("Test sort names ascending failed: ", expectedNames.toString(), sortedNames.toString());
        assertEquals("Test sort codes descending failed: ", expectedCodes.toString(), sortedCodes.toString());
    }

    /**
     * A test for the graph connection
     */
    @Test
    public void graphConnectionTest() {
        // True if the nodes are connected and false if they are not.
        assertEquals("Connection search failed: ", true, manager.isConnected(manager.getCompanies().get(7), manager.getCompanies().get(5)));
        assertEquals("Connection search failed: ", false, manager.isConnected(manager.getCompanies().get(7), manager.getCompanies().get(2)));
    }

    /**
     * A test for the customer limit
     */
    @Test
    public void checkCustomerLimit() {
        Staff staff = new Staff("Jill Lai", 369, "jl@multi.ac.uk", "1/2015", "16-00");

        Customer customer1 = new Customer("John J", 147, "jj@multi.ac.uk", 999999, "Apple");
        Customer customer2 = new Customer("Kate K", 565, "kk@multi.ac.uk", 0746025, "MS");
        Customer customer3 = new Customer("Loius L", 6542, "ll@multi.ac.uk", 999999, "SMT");
        Customer customer4 = new Customer("Zhang Z", 805, "zz@multi.ac.uk", 999999, "NXS");

        assertEquals ("Test adding customer failed: ", true, staff.addCustomer(customer3));
        //Add customers to staff just to carry out the next test.
        staff.addCustomer(customer1);
        staff.addCustomer(customer2);
        staff.addCustomer(customer1);
        staff.addCustomer(customer4);

        //Test to check that the customer list does not exceed the maximum number of customers,
        //Also confirms that a customer is not added twice, in this case, customer 1 cannot be added twice,
        //And customer 4 cannot be added since the list has reached its max already.
        assertEquals ("Test customer limit failed: ", staff.MAX_NUM_CUSTOMERS, staff.getCustomerList().size());

        //Test to check that customer can be removed from the customer list
        assertEquals ("Test removing customer failed: ", true, staff.removeCustomer(customer3));

    }
}
