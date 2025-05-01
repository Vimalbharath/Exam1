package Graph;

import java.util.Arrays;
import java.util.Comparator;

public class Kruskal {
    public static class DSU {
        public int[] parent;
        public int[] rank;

        public DSU(int V) {
            parent = new int[V];
            rank = new int[V];
            for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a != b) {
                if (rank[a] > rank[b]) {
                    parent[b] = a;
                } else if (rank[a] < rank[b]) {
                    parent[a] = b;
                } else {
                    parent[b] = a;
                    rank[a]++;
                }
            }
        }
    }

    public static int kruskalsMST(int V, int[][] edges) {
        DSU dsu = new DSU(V);
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        int cost = 0, count = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dsu.find(u) != dsu.find(v)) {
                dsu.union(u, v);
                count++;
                cost = cost + w;
                if (count == (V - 1)) {
                    break;
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {

        // An edge contains, weight, source and destination
        int[][] edges = {
                { 0, 1, 10 }, { 1, 3, 15 }, { 2, 3, 4 }, { 2, 0, 6 }, { 0, 3, 5 }
        };

        System.out.println(kruskalsMST(4, edges));
    }
}
