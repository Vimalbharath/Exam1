package Graph;

public class Dijiskstra {

    public int[] dmatrix(int[][] matrix) {
        int[] dist = new int[4];
        for (int element : dist) {
            element = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        int j = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (dist[i] > matrix[j][i] + dist[j]) {
                dist[i] = matrix[j][i] + dist[j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 2, 3, 4 },
                { 2, 0, 0, 0 },
                { 3, 0, 0, 0 },
                { 4, 5, 0, 0 }
        };
        System.out.println(dmatrix(matrix));
    }
}
