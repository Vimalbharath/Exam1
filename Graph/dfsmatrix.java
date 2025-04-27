package Graph;

public class dfsmatrix {

    public static void dfs(int[][] graph, int start, int[] visited) {
        visited[start] = 1;
        System.out.println(start);
        for (int i = 0; i < graph.length; i++) {
            int v = graph[start][i];
            if (visited[i] == 0 && v == 1) {
                dfs(graph, i, visited);
            }

        }

    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 1 },
                { 1, 0, 1, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        int[] visited = new int[graph.length];

        dfs(graph, 0, visited);
    }
}
