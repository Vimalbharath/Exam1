package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    public void topo() {
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                topo(visited, i, st);
            }
        }
        while (!st.empty()) {
            System.out.println(st.pop());
        }
    }

    public void topo(int[] visited, int start, Stack<Integer> st) {
        visited[start] = 1;
        for (int e : adjListArray[start]) {
            if (visited[e] == 0) {
                topo(visited, e, st);
            }
        }
        st.push(start);
    }

    public void khan() {
        int[] indegree = new int[V];
        for (List<Integer> a : adjListArray) {
            for (int b : a) {
                indegree[b]++;
            }
        }

        Queue<Integer> list = new LinkedList<Integer>();
        int count = 0;
        while (!(count == V)) {
            int sss = list.size();
            System.out.println(sss);
            for (int i = 0; i < V; i++) {
                if (indegree[i] == 0) {
                    list.add(i);
                    count++;
                    for (int b : adjListArray[i]) {
                        indegree[b]--;
                    }
                }
            }

        }
        while (!list.isEmpty()) {
            System.out.println(list.poll());
        }

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
        graph.topo();
        graph.khan();

    }
}
