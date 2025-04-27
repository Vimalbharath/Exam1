package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dlist {

    public static class iPair {
        int first;
        int second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;

        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }

    public static class Graph {
        ArrayList<ArrayList<iPair>> adjList;
        int numVertices;

        public Graph(int vertices) {
            this.numVertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v, int weight) {
            adjList.get(u).add(new iPair(v, weight));
            // For an undirected graph, you would also add the reverse edge:
            // adjList.get(v).add(new IPair(u, weight));
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Vertex " + i + ": ");
                for (iPair neighbor : adjList.get(i)) {
                    System.out.print("(" + neighbor.first + ", " + neighbor.second + ") ");
                }
                System.out.println();
            }
        }

        public int[] dijilist() {
            int[] dist = new int[numVertices];
            for (int i = 0; i < dist.length; i++) {
                dist[i] = Integer.MAX_VALUE;

            }
            PriorityQueue<iPair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.second));
            dist[0] = 0;
            pq.add(new iPair(0, dist[0]));
            while (pq.size() != 0) {
                iPair pair = pq.poll();
                int first = pair.getFirst();
                int second = pair.getSecond();
                for (int i = 0; i < adjList.get(first).size(); i++) {
                    int v = adjList.get(first).get(i).first;
                    if (dist[v] > dist[first] + adjList.get(first).get(i).second) {
                        dist[v] = dist[first] + adjList.get(first).get(i).second;
                        pq.add(new iPair(v, dist[v]));
                    }

                }

            }
            return dist;
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        Graph graph = new Graph(vertices); // Direct instantiation of the static inner class

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 3, 5);

        System.out.println("Adjacency List representation of the graph:");
        graph.printGraph();

        System.out.println(Arrays.toString(graph.dijilist()));

        int vertices2 = 5;
        Graph graph2 = new Graph(vertices2);

        graph2.addEdge(0, 1, 10);
        graph2.addEdge(0, 4, 5);
        graph2.addEdge(1, 2, 1);
        graph2.addEdge(1, 4, 2);
        graph2.addEdge(2, 3, 4);
        graph2.addEdge(3, 2, 6);
        graph2.addEdge(4, 1, 3);
        graph2.addEdge(4, 2, 9);
        graph2.addEdge(4, 3, 2);

        System.out.println("Adjacency List representation of the graph (Test Case 2):");
        graph2.printGraph();
        System.out.println("Dijkstra's shortest distances from vertex 0 (Test Case 2):");
        System.out.println(Arrays.toString(graph2.dijilist()));
    }
}
