package Graph;

import java.util.ArrayList;

public class dfslist {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s,
            int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                dfs(adj, visited, i);
                System.out.println(i);
            }
        }

    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int i) {

        if (visited[i] == 0) {
            visited[i] = 1;
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        int V = 6;
        // Create an adjacency list for the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the edges of the graph
        int[][] edges = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        // Populate the adjacency list with edges
        for (int[] e : edges) {
            addEdge(adj, e[0], e[1]);
        }

        dfs(adj);

    }
}
