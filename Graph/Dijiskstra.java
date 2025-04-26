package Graph;

import java.util.Arrays;

public class Dijiskstra {

    public static int[] dmatrix(int[][] matrix) {
        int[] dist = new int[4];
        // for (int val : dist) {
        // val = Integer.MAX_VALUE;
        // }
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (dist[i] > matrix[j][i] + dist[j]) {
                    dist[i] = matrix[j][i] + dist[j];
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
