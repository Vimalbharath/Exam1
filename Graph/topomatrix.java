package Graph;

import java.util.Stack;

public class topomatrix {

    public static void dfs(int[][] graph) {
        int[] visited = new int[graph.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                dfs(graph, i, visited, st);
                st.push(i);
            }

        }
        while (!st.empty()) {
            System.out.println(st.pop());
        }

    }

    public static void dfs(int[][] graph, int start, int[] visited, Stack<Integer> st) {
        visited[start] = 1;
        // System.out.println(start);
        for (int i = 0; i < graph.length; i++) {
            int v = graph[start][i];
            if (visited[i] == 0 && v == 1) {
                dfs(graph, i, visited, st);
                st.push(i);
            }

        }

    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 0, 0, 0, 0, 0, },
                { 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 0, 0 }
        };

        dfs(graph);
    }
}
