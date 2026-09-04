import java.util.*;

class BellmanFord {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bellmanFord(ArrayList<Edge> edges, int V, int src) {

        // Step 1: Create distance array
        int dist[] = new int[V];

        // Initially, distance of every vertex is infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Distance from source to itself is 0
        dist[src] = 0;

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {

            for (Edge e : edges) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxation
                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 3: Check for negative weight cycle
        for (Edge e : edges) {

            int u = e.src;
            int v = e.dest;
            int wt = e.wt;

            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + wt < dist[v]) {

                System.out.println("Negative weight cycle exists!");
                return;
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + src + ":");

        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<Edge> edges = new ArrayList<>();

        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, -4));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(2, 4, 2));
        edges.add(new Edge(3, 4, 4));

        bellmanFord(edges, V, 0);
    }
}