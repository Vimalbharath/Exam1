package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {

    List<LinkedList<Integer>> graph;
    public boolean directed;

    public AdjacencyList(int noofvertices, boolean directed) {
        graph = new ArrayList<LinkedList<Integer>>(noofvertices);
        this.directed = directed;
    }

    public void addedge(int u, int v) {
        addedge(graph, u, v);
    }

    public void addedge(List<LinkedList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        if (!directed) {
            graph.get(v).add(u);
        }
    }

    public void printgraph() {
        System.out.println("Printing adjacency list");
        for (LinkedList<Integer> list : graph) {
            for (int val : list) {
                System.out.print(" " + val + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList(5, false);
        graph.addedge(2, 4);
        graph.addedge(2, 1);
        graph.printgraph();
    }

}
