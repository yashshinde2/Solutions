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

        int dist[] = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        for (int i = 0; i < V - 1; i++) {

            for (Edge e : edges) {

                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + wt < dist[v]) {

                    dist[v] = dist[u] + wt;
                }
            }
        }

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