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
            if (visited[i] != 0) {
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
    }

}
