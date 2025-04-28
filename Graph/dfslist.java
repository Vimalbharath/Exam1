package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class dfslist {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int s,
            int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[adj.size()];
        int[] arrival = new int[adj.size()];
        int[] depature = new int[adj.size()];
        int time = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0) {
                // visited[i] = 1;
                dfs(adj, visited, i, arrival, depature, time);

            }
        }
        System.out.println(Arrays.toString(arrival));
        System.out.println(Arrays.toString(depature));

    }

    public static int dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int i, int[] arrival, int[] depature,
            int time) {
        visited[i] = 1;
        time = time + 1;
        arrival[i] = time;
        System.out.println(i);
        for (int j = 0; j < adj.get(i).size(); j++) {
            int v = adj.get(i).get(j);
            if (visited[v] == 0) {
                // visited[v] = 1;
                time = dfs(adj, visited, v, arrival, depature, time);
            }
        }
        time = time + 1;
        depature[i] = time;
        return time;

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
