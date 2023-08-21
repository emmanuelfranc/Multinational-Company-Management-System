import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class maintains an ArrayList that stores a list of companies and graph
 * that indicates the relationship of those companies. Your task is to correctly
 * implement the method bodies for:
 *
 * protected boolean isConnected(Graph graph, Company i, Company j) protected
 * ArrayList<Company> mergeSort(ArrayList<Company> list, boolean ascending,
 * String attr)
 *
 * The above methods are called via public methods of the same name which supply
 * the local modules object as a parameter. You can observe calls to these
 * public methods in the go method of ManagerTest.java.
 */
public class MultinationalManager {
    private ArrayList<Company> companies;
    private Graph graph;

    public MultinationalManager() {
        companies = new ArrayList<Company>();
        graph = new Graph();
    }

    /**
     * Cleans the object
     */
    public void clear() {
        for (Company v : companies) {
            v.getBtree().clear();
        }
        companies.clear();
        graph = new Graph();
    }

    /**
     * Add a company
     *
     * @param v the new company
     */
    public void addCompany(Company v) {
        companies.add(v);
    }

    /**
     * Get all companies
     *
     * @return An arraylist of companies
     */
    public ArrayList<Company> getCompanies() {
        return companies;
    }

    /**
     * Get the graph
     *
     * @return the graph
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * Add a new relationship (i.e., edge) between two companies (i <-> j)
     *
     * @param i Company
     * @param j Company
     */
    public void addRelationship(Company i, Company j) {
        graph.insertEdge(i, j);
    }

    public void describeCompanies() {
        for (Company v : companies) {
            System.out.println(v.toString());
            v.describeStudentTree();
        }
    }

    /**
     * This method calls the tree walk method for a specific Company
     *
     * @param val The index of the company that you want to call the method for
     * @return A String with the names of all Customers in the tree
     */
    public String walkTree(int val) {
        return companies.get(val).walkTree();
    }

    /**
     * This method calls the find method for a specific Company
     *
     * @param val  The index of the company that you want to call the method for
     * @param name Name of the customer we are looking for
     * @return A reference to the Customer that was found or null if no Customer
     *         found
     */
    public Customer find(int val, String name) {
        return companies.get(val).find(name);
    }

    /**
     * This method calls the protected isConnected to find if two nodes are somehow
     * connected in the graph.
     *
     * You should not modify this code.
     */
    public boolean isConnected(Company i, Company j) {
        return isConnected(this.graph, i, j);
    }

    /**
     * This method should search and find if two nodes are somehow connected in an
     * undirected graph.
     *
     * @param graph The graph
     * @param i     the starting node
     * @param j     the ending node
     *
     * @return true, if nodes i and j are connected in any way, false otherwise
     */
    protected boolean isConnected(Graph graph, Company i, Company j) {
        LinkedList <Company> visited = new LinkedList<Company>(); //A LinkedList to store the nodes that have been visited.

        Queue <Company> notVisited = new LinkedList<Company>(); //A queue to store the nodes yet to be visited.

        notVisited.add(i); //Add the starting node to the queue of the nodes not visited

        while(!notVisited.isEmpty()) { //While unvisited nodes are not empty, ie, while there are nodes yet to be visited, keep going through the graph
            if (visited.contains(j)) { // If j, the ending node is visited already, return true. This will mean that i and j are connected.
                return true;
            }
            Company next = notVisited.poll();  //remove the node stored in the queue and set it to the company variable, making the company variable head of the queue
            if (!visited.contains(next)) {
                visited.add(next);
            }
            LinkedList<Company> adjVertices = graph.getAdj(next);
            for (int adj = 0; adj < adjVertices.size();adj++) {
                Company k = adjVertices.get(adj);
                if (!visited.contains(k)) {
                    notVisited.add(k);
                    if (k.equals(j)) return true;
                }
            }
        }
        return false;
    }

    /**
     * This method should use merge sort approach to rearrange the references in the
     * ArrayList of 'Company' such that they are in order according to the attr
     * (attribute) parameter. If asc is true, this should be ascending order, if asc
     * is false, this should be descending order.
     *
     * You should not modify this code.
     *
     * @param asc  True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
     * @return The ArrayList of 'Company' that has been sorted using merge sort
     */
    public ArrayList<Company> mergeSort(boolean asc, String attr) {
        ArrayList<Company> sorted = new ArrayList<Company>(companies);
        return mergeSort(sorted, asc, attr);
    }

    /**
     * This method should use merge sort approach to rearrange the references in the
     * ArrayList of 'Company' such that they are in order according to the attr
     * (attribute) parameter. If asc is true, this should be ascending order, if asc
     * is false, this should be descending order.
     *
     * @param list The arrayList to be sorted
     * @param asc  True if the list should be ascending order, false for descending
     * @param attr Attribute (name or code) that will be use during the sorting
     * @return The ArrayList of 'Company' that has been sorted using merge sort
     */
    protected ArrayList<Company> mergeSort(ArrayList<Company> list, boolean ascending, String attr) {

        if (list.size() <= 1)return list; //If the size of the list is less than or one, then there is nothing to sort; hence, return the list.
        int middle = list.size() / 2; //Find the middle of the list and store it in a variable.

        ArrayList<Company> left = new ArrayList<>();
        //Copy the first half of the list into left
        for (int i = 0; i < middle; i++) {
            left.add(list.get(i));
        }
        //Copy the second half of the list into right
        ArrayList<Company> right = new ArrayList<>();
        for (int j = middle; j < list.size(); j++) {
            right.add(list.get(j));
        }

        mergeSort (left, ascending, attr);
        mergeSort (right, ascending, attr);
        merge(left, right, list, ascending, attr);

        return list;
    }
    /**
     * Merges two sorted ArrayLists into an ArrayList
     * @param first   The first sorted ArrayList
     * @param second  The second sorted ArrayList
     * @param list    The ArrayList into which to merge the first and second.
     * @param asc  	  True if the list should be ascending order, false for descending
     * @param attr	  Attribute (name or code) that will be use during the sorting
     */
    protected ArrayList<Company> merge(ArrayList<Company> first, ArrayList<Company> second,
                                       ArrayList<Company> list, boolean asc, String attr) {

        int iFirst = 0;  //Next element to be considered in the first ArrayList
        int iSecond = 0; //Next element to be considered in the second ArrayList
        int j = 0;		 //Next open position in the list

        if (asc == false && attr.equals("code")) {
            //As long as neither iFirst nor iSecond has exceeded the end, move the smaller element into the list.
            while (iFirst < first.size() && iSecond < second.size()) {
                if (second.get(iSecond).isLessThan(first.get(iFirst))) {
                    list.set(j, first.get(iFirst));
                    iFirst++;
                } else {
                    list.set(j, second.get(iSecond));
                    iSecond++;
                }
                j++;
            }
        }
        //Do the same for each attribute and 'asc'
        else if (asc == true && attr.equals("code")) {
            while (iFirst < first.size() && iSecond < second.size()) {
                if (first.get(iFirst).isLessThan(second.get(iSecond))) {
                    list.set(j, first.get(iFirst));
                    iFirst++;
                } else {
                    list.set(j, second.get(iSecond));
                    iSecond++;
                }
                j++;
            }
        }
        else if (asc == true && attr == "name") {
            while (iFirst < first.size() && iSecond < second.size()) {
                if (second.get(iSecond).compareToIgnoreCase(first.get(iFirst))) {
                    list.set(j, first.get(iFirst));
                    iFirst++;
                } else {
                    list.set(j, second.get(iSecond));
                    iSecond++;
                }
                j++;
            }
        }
        else if (asc == false && attr == "name") {
            while (iFirst < first.size() && iSecond < second.size()) {
                if (first.get(iFirst).compareToIgnoreCase((second.get(iSecond)))) {
                    list.set(j, first.get(iFirst));
                    iFirst++;
                } else {
                    list.set(j, second.get(iSecond));
                    iSecond++;
                }
                j++;
            }
        }
        //Copy any remaining entries of the first part of the arrayList
        while (iFirst < first.size()) {
            list.set(j, first.get(iFirst));
            iFirst++;
            j++;
        }
        //Copy any remaining entries of the second half
        while (iSecond < second.size()) {
            list.set(j, second.get(iSecond));
            iSecond++;
            j++;
        }

        return list;
    }
    //Merge Sort adopted from Big Java early Objects --The required textbook for this course.
}
