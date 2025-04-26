package Graph;

import java.util.Arrays;

public class Dijiskstra {

    public static int[] dmatrix(int[][] matrix) {
        int[] dist = new int[4];
        boolean[] visited = new boolean[4];
        // for (int val : dist) {
        // val = Integer.MAX_VALUE;
        // }
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[0] = 0;
        visited[0] = true;

        for (int i = 1; i < matrix.length; ++i) { /* Important bellman ford */

            for (int u = 0; u < matrix.length; u++) {
                for (int v = 0; v < matrix.length; v++) {
                    if (!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                            && dist[v] > matrix[u][v] + dist[u]) {
                        dist[v] = matrix[u][v] + dist[u];
                    }
                }
            }
        }

        for (int u = 0; u < matrix.length; ++u) {
            for (int v = 0; v < matrix.length; ++v) {
                if (matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + matrix[u][v] < dist[v]) {
                    System.out.println("Graph contains negative weight cycle");
                    return null; // Indicate the presence of a negative cycle
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 3, 4 },
                { 2, 0, 0, 5 },
                { 3, 0, 0, 0 },
                { 4, 5, 0, 0 }
        };
        int sourceVertex = 0;
        int[] shortestDistances = dmatrix(graph);

        if (shortestDistances != null) {
            System.out.println("Shortest distances from source vertex " + sourceVertex + ":");
            for (int i = 0; i < shortestDistances.length; ++i) {
                System.out.println("To vertex " + i + ": "
                        + (shortestDistances[i] == Integer.MAX_VALUE ? "Infinity" : shortestDistances[i]));
            }
        }

        System.out.println("\nExample with a potential negative edge (not a cycle in this specific graph):");
        int[][] graphWithNegative = {
                { 0, 2, 3, 4 },
                { 2, 0, -1, 5 },
                { 3, 0, 0, 0 },
                { 4, 5, 0, 0 }
        };
        int[] shortestDistancesNegative = dmatrix(graphWithNegative);

        if (shortestDistancesNegative != null) {
            System.out.println(
                    "Shortest distances from source vertex " + sourceVertex + " (with potential negative edge):");
            for (int i = 0; i < shortestDistancesNegative.length; ++i) {
                System.out.println(
                        "To vertex " + i + ": " + (shortestDistancesNegative[i] == Integer.MAX_VALUE ? "Infinity"
                                : shortestDistancesNegative[i]));
            }
        }

        System.out.println("\nExample with a negative cycle:");
        int[][] graphNegativeCycle = {
                { 0, 2, 3, 4 },
                { 2, 0, -3, 5 },
                { 3, -1, 0, 0 },
                { 4, 5, 2, 0 }
        };
        int[] shortestDistancesNegativeCycle = dmatrix(graphNegativeCycle);
        if (shortestDistancesNegativeCycle != null) {
            System.out.println(
                    "Shortest distances from source vertex " + sourceVertex + " (with potential negative edge):");
            for (int i = 0; i < shortestDistancesNegative.length; ++i) {
                System.out.println(
                        "To vertex " + i + ": " + (shortestDistancesNegative[i] == Integer.MAX_VALUE ? "Infinity"
                                : shortestDistancesNegative[i]));
            }
        }
    }
}
