package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class AdajacencyMatrix {
    public int[][] data;

    public boolean directed;

    // public void setdirected() {
    // directed = true;
    // }

    public AdajacencyMatrix(int noofvertex, boolean directed) {
        data = new int[noofvertex][noofvertex];
        this.directed = directed;
    }

    public void addedge(int u, int v) {
        addedge(data, u, v);
    }

    public void addedge(int[][] data, int u, int v) {
        data[u][v] = 1;
        if (!directed) {
            data[v][u] = 1;
        }
    }

    public void printgraph() {
        System.out.println("Printing adjacency matrix");
        for (int[] arr : data) {
            for (int val : arr) {
                System.out.print(" " + val + " ");
            }
            System.out.println();

        }
    }

    public void bfs() {
        int[] visited = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int a = q.poll();
                    System.out.println(a + "->");
                    for (int j = 0; j < data.length; j++) {
                        if (data[a][j] != 0 && visited[j] == 0) {
                            visited[j] = 1;
                            q.add(j);
                        }
                    }
                }

            }
        }

    }

    public static void main(String[] args) {
        AdajacencyMatrix graph = new AdajacencyMatrix(5, false);
        graph.addedge(2, 4);
        graph.addedge(2, 1);
        graph.printgraph();
        graph.bfs();
        // --- Test Case 2 ---
        System.out.println("--- Test Case 2 ---");
        AdajacencyMatrix graph2 = new AdajacencyMatrix(6, false);
        graph2.addedge(0, 1);
        graph2.addedge(0, 2);
        graph2.addedge(1, 3);
        graph2.addedge(2, 3);
        graph2.addedge(2, 4);
        graph2.addedge(4, 5);
        graph2.printgraph();
        graph2.bfs(); // Start BFS from vertex 0
        System.out.println();

        // --- Test Case 3 (Starting from a different vertex) ---
        System.out.println("--- Test Case 3 ---");
        AdajacencyMatrix graph3 = new AdajacencyMatrix(6, false);
        graph3.addedge(0, 1);
        graph3.addedge(0, 2);
        graph3.addedge(1, 3);
        graph3.addedge(2, 3);
        graph3.addedge(2, 4);
        graph3.addedge(4, 5);
        graph3.printgraph();
        graph3.bfs(); // Start BFS from vertex 2
        System.out.println();

        // --- Test Case 4 (Disconnected graph) ---
        System.out.println("--- Test Case 4 ---");
        AdajacencyMatrix graph4 = new AdajacencyMatrix(7, false);
        graph4.addedge(0, 1);
        graph4.addedge(2, 3);
        graph4.addedge(4, 5);
        graph4.addedge(5, 6);
        graph4.printgraph();
        graph4.bfs(); // Start BFS from vertex 0 (will only explore the connected component)

    }

}
