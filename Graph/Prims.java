package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    public static class Pair implements Comparable<Pair> {
        int v;
        int wt;

        Pair(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }

        public int compareTo(Pair that) {
            return this.wt - that.wt;
        }
    }

    public static int spanningTree(int V, int E, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        pq.add(new Pair(0, 0));
        int[] vis = new int[V];
        int s = 0;
        while (!pq.isEmpty()) {
            Pair a = pq.poll();
            int u = a.v;
            int w = a.wt;
            if (vis[u] == 1) {
                continue;
            }
            s = s + w;
            vis[u] = 1;
            for (Pair b : adj.get(u)) {
                if (vis[b.v] == 0) {
                    pq.add(new Pair(b.v, b.wt));
                }

            }

        }
        return s;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 1, 5 },
                { 1, 2, 3 },
                { 0, 2, 1 } };

        // Function call
        System.out.println(spanningTree(3, 3, graph));
    }
}
