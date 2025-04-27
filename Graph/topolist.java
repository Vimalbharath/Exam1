package Graph;

import java.util.LinkedList;
import java.util.List;

import Graph.Dlist.Graph;

public class topolist {
    int V; // No. of vertices

    List<Integer> adjListArray[];

    public topolist(int V) {

        this.V = V;

        @SuppressWarnings("unchecked")
        List<Integer> adjListArray[] = new LinkedList[V];

        this.adjListArray = adjListArray;

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Utility function to add edge
    public void addEdge(int src, int dest) {

        this.adjListArray[src].add(dest);

    }

    public static void main(String[] args) {

        // Create a graph given in the above diagram
        topolist graph = new topolist(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        System.out.println("Topological sorts");

    }
}
