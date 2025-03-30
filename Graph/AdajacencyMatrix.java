package Graph;

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

    public static void main(String[] args) {
        AdajacencyMatrix graph = new AdajacencyMatrix(5, false);
        graph.addedge(2, 4);
        graph.addedge(2, 1);
        graph.printgraph();
    }

}
