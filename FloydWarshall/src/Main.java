class FloydWarshall {
    static final int INF = 99999;

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        // Copy the input graph to the distance matrix
        for (int i = 0; i < V; i++) {
            System.arraycopy(graph[i], 0, dist[i], 0, V);
        }

        // Apply Floyd-Warshall algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // Print the shortest distance matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 8, INF},
                {4, 0, INF, 2},
                {8, INF, 0, 5},
                {INF, 2, 5, 0}
        };
        floydWarshall(graph, 4);
    }
}
