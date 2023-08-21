import java.util.*;

/**
 * BinaryTree - An example of a Binary Tree built using Node objects. Some of
 * the functionality for this class is provided for you (and may provide clues
 * as to how to implement assignment methods). Your main task is to implement the
 * method bodies for:
 *
 * 		protected void walkTree(Node n, StringBuffer sb)
 * 		protected Customer find(String name, Node n)
 *
 */
public class BinaryTree {

    private Node root; // The root node of the tree
    private int size; // A count of the nodes in the tree

    public BinaryTree(Customer[] sdtList) {
        root = null;
        size = 0;

        for (Customer s : sdtList) {
            addNode(s);
        }
    }

    public BinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of nodes in the tree.
     *
     * @return Number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Empties the tree
     */
    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * @return the root of the tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Determines if the tree is empty or not.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Adds a Node containing a reference to the object to the tree.
     *
     * @param a   The content of the node that will be added
     */
    public void addNode(Customer a) {
        Node node = new Node(a);

        // If tree is empty, make our new node the root and leave
        if (root == null) {
            root = node;
            size = 1;
        } else {
            // Start the recursive calls to add the descendants of node 'p'
            addNode(node, root);
            size = size + 1;
        }

    }

    /**
     * Internal recursive method to add a node to the tree.
     *
     * @param c   The content to place in the tree
     * @param n   The current node to consider, will not be null
     */
    private void addNode(Node c, Node n) {
        // Is our new node content less than our current node content?
        // If it is, we add it to the left side of the tree so that when
        // we walk it with an in-order traversal, the tree content will
        // come out in alphabetic order. Conversely add it to the right if it
        // is greater.
        if (c.compareTo(n) < 0) {
            if (n.hasLeft())
                addNode(c, n.left());
            else {
                // The current left node is null so we can
                // attach our new node to the left of the current node
                n.setLeft(c);
                return;
            }
        } else {
            if (n.hasRight())
                addNode(c, n.right());
            else {
                // The current right node is null so we can
                // attach our new node to the right of the current node
                n.setRight(c);
                return;
            }
        }
    }

    /**
     * Public call to start the tree walk using the root of the tree.
     *
     * @return A reference to a comma separated String containing the trees contents.
     */
    public String walkTree() {
        StringBuffer buff = new StringBuffer();

        if (root == null)
            return "Empty Tree!";
        else
            walkTree(root, buff);

        return buff.toString();
    }

    /**
     * Protected method used to walk over the tree.
     *
     * @param n The current node
     * @param sb The StringBuffer
     */
    protected void walkTree(Node n, StringBuffer sb) {
//		sb.append(n.getNodeObjectName() + ",");
        if (n.getNodeObjectName() == null)return; //returns if the node is empty

        Queue <Node> queue = new LinkedList<Node>(); //create a queue of type node to add the visited nodes
        queue.add(n); // add the current node to the queue.
        while(!queue.isEmpty())
        {
            Node temp = queue.remove();
            if (temp.hasLeft()) queue.add(temp.left());
            if (temp.hasRight()) queue.add(temp.right());
            sb.append(temp.getNodeObjectName() + ",");
        }
        //Breadth first search adopted from Big Java Early objects -- The required textbook for this course.

    }
    /**
     * Find the Node by 'name'
     *
     * @param name The name to search for
     * @return A reference to the Node that was found or null if no Node found
     */
    public Customer find(String name) {
        return find(name, root);
    }

    /**
     * Internal protected method used to search the tree from node 'n' looking for a
     * Node with the given 'name'. You should provide the correct recursive
     * implementation for this method. Some helpful lines of code have been
     * included...
     *
     * @param name	The name to search for
     * @param n		The current node in the tree to search from
     * @return		A reference to the node that was found or null if not found
     */
    protected Customer find(String name, Node n) {
        if (n == null) return null; //If the current node, ideally the parent, is empty, this will mean that there are no child nodes, hence, return.
        int order = name.compareTo(n.getNodeObjectName());

        if (order == 0)return n.getNodeObject();
        else if (order > 0 && n.hasRight())return find (name, n.right());
        else if (order < 0 && n.hasLeft())return find(name, n.left());
        else return null;
    }

    public void printTree() {
        printTree(root, 0);
    }

    /**
     * Internal method used to make a recursive reverse order walk from node 'n'.
     * This method is useful to see the current structure of the tree (turned on its
     * side)
     *
     * @param n   	The node to start the reverse order walk from
     * @param depth	The current depth of the node in the tree
     */
    private void printTree(Node n, int depth) {
        if (n.hasRight())
            printTree(n.right(), depth + 1);

        // Show depth of current code by indenting to the right
        for (int d = 0; d < depth; d++)
            System.out.print("  ");

        System.out.println(n.getNodeObjectName());

        if (n.hasLeft())
            printTree(n.left(), depth + 1);
    }

}
