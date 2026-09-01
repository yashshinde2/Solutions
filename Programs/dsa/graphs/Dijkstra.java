// Graphs - Dijkstra algorithm

import java.util.*;

class Dijkstra {

    static class Edge {

        int dest;
        int weight;

        Edge(int d, int w) {
            dest = d;
            weight = w;
        }
    }

    static class Pair implements Comparable<Pair> {

        int node;
        int distance;

        Pair(int n, int d) {
            node = n;
            distance = d;
        }

        @Override
        public int compareTo(Pair p) {
            return this.distance - p.distance;
        }
    }

    static void dijkstra(
            ArrayList<Edge>[] graph,
            int source) {

        int V = graph.length;

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>();

        pq.add(new Pair(source, 0));

        while(!pq.isEmpty()) {

            Pair current = pq.remove();

            int node = current.node;
            int currentDist = current.distance;

            if(currentDist != dist[node]) {
                continue;
            }

            for(Edge e : graph[node]) {

                int newDist =
                        currentDist + e.weight;

                if(newDist < dist[e.dest]) {

                    dist[e.dest] = newDist;

                    pq.add(
                        new Pair(
                            e.dest,
                            newDist
                        )
                    );
                }
            }
        }

        for(int i = 0; i < V; i++) {

            System.out.println(
                "0 -> " + i + " = " + dist[i]
            );
        }
    }

    static void addEdge(
            ArrayList<Edge>[] graph,
            int src,
            int dest,
            int weight) {

        graph[src].add(
            new Edge(dest, weight)
        );

        graph[dest].add(
            new Edge(src, weight)
        );
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph =
                new ArrayList[V];

        for(int i = 0; i < V; i++) {

            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 2, 2);
        addEdge(graph, 1, 3, 1);
        addEdge(graph, 2, 3, 3);

        dijkstra(graph, 0);
    }
}