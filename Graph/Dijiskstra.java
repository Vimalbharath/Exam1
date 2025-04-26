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

        for (int u = 0; u < matrix.length; u++) {
            for (int v = 0; v < matrix.length; v++) {
                if (!visited[v] && matrix[u][v] != 0 && dist[u] != Integer.MAX_VALUE
                        && dist[v] > matrix[u][v] + dist[u]) {
                    dist[v] = matrix[u][v] + dist[u];
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 2, 3, 4 },
                { 2, 0, 0, 5 },
                { 3, 0, 0, 0 },
                { 4, 5, 0, 0 }
        };
        System.out.println(Arrays.toString(dmatrix(matrix)));
    }
}
