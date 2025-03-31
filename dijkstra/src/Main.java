import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<int[]>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList[source].add(new int[]{destination, weight});
        adjacencyList[destination].add(new int[]{source, weight}); // For undirected graph
    }

    public void dijkstra(int source) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], dist = current[1];

            for (int[] neighbor : adjacencyList[node]) {
                int nextNode = neighbor[0], edgeWeight = neighbor[1];
                int newDist = dist + edgeWeight;

                if (newDist < distance[nextNode]) {
                    distance[nextNode] = newDist;
                    pq.add(new int[]{nextNode, newDist});
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 8);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 6);
        graph.addEdge(3, 5, 6);

        graph.dijkstra(0);
    }
}
