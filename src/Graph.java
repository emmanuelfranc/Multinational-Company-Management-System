import java.security.DomainCombiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Graph - A class that implements an undirected graph using adjacency (linked) lists,
 * as explained in Week 6.
 *
 * ATTENTION: You do NOT need to modify this code at all.
 *
 */

public class Graph {
    private ArrayList<LinkedList<Company>> adj;  // the adjacency list
    private ArrayList<Company> vertices;  // the list of nodes

    /**
     * Constructor
     */
    public Graph() {
        adj = new ArrayList<LinkedList<Company>>();
        vertices = new ArrayList<Company>();
    }

    public ArrayList<Company> getVertices() {
        return this.vertices;
    }

    /**
     * Add a node.
     * @param i The node
     */
    public void insertNode(Company i) {
        vertices.add(i);
        adj.add(new LinkedList<Company>());
    }

    /**
     * Add an edge to the graph.
     * If the starting or ending node do not exist, it is created.
     *
     * @param i Starting node
     * @param j Ending node
     */
    public void insertEdge(Company i, Company j) {
        if (vertices.contains(i) && vertices.contains(j) &&
                !adj.get(vertices.indexOf(i)).contains(j) && !adj.get(vertices.indexOf(j)).contains(i)) {
            adj.get(vertices.indexOf(i)).add(j);
            adj.get(vertices.indexOf(j)).add(i);
        } else if (vertices.contains(j) && !adj.get(vertices.indexOf(j)).contains(i)) {
            if (!vertices.contains(i)) {
                vertices.add(i);
                adj.add(new LinkedList<Company>(Arrays.asList(j)));
            }
            adj.get(vertices.indexOf(j)).add(i);
        }
        else if (vertices.contains(i) && !adj.get(vertices.indexOf(i)).contains(j)) {
            if (!vertices.contains(j)) {
                vertices.add(j);
                adj.add(new LinkedList<Company>(Arrays.asList(i)));
            }
            adj.get(vertices.indexOf(i)).add(j);
        } else {
            vertices.add(i);
            adj.add(new LinkedList<Company>(Arrays.asList(j)));
            vertices.add(j);
            adj.add(new LinkedList<Company>(Arrays.asList(i)));
        }
    }

    /**
     * Remove edge.
     *
     * @param i Starting node
     * @param j Ending node
     */
    public void removeEdge(Company i, Company j) {
        if (vertices.contains(i)) {
            int index = vertices.indexOf(i);
            if (adj.get(index).contains(j)) {
                adj.get(index).remove(j);
            }
        }

        if (vertices.contains(j)) {
            int index = vertices.indexOf(j);
            if (adj.get(index).contains(i)) {
                adj.get(index).remove(i);
            }
        }
    }

    /**
     * Get adjacency list of Node i
     * @param i The node
     * @return Adjacency list
     */
    public LinkedList<Company> getAdj(Company i) {
        int index = vertices.indexOf(i);
        if (index != -1) {
            return adj.get(index);
        } else {
            return new LinkedList<Company>();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            s.append(vertices.get(i) + " -> ");
            for (int j = 0; j < adj.get(i).size(); j++) {
                s.append(adj.get(i).get(j) + " -> ");
            }
            s.append("\n");
        }
        return s.toString();

    }
}
