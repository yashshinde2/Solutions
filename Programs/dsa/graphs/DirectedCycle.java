import java.util.*;

class DirectedCycle {

    static class Edge {

        int src;
        int dest;

        Edge(int s, int d) {
            src = s;
            dest = d;
        }
    }

    static boolean detectCycle(
            ArrayList<Edge>[] graph,
            boolean[] visited,
            boolean[] recursionStack,
            int curr) {

        visited[curr] = true;
        recursionStack[curr] = true;

        for(Edge e : graph[curr]) {

            if(!visited[e.dest]) {

                if(detectCycle(
                        graph,
                        visited,
                        recursionStack,
                        e.dest)) {

                    return true;
                }
            }

            else if(recursionStack[e.dest]) {

                return true;
            }
        }

        recursionStack[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph =
                new ArrayList[V];

        for(int i = 0; i < V; i++) {

            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));

        boolean[] visited = new boolean[V];

        boolean[] recursionStack = new boolean[V];

        for(int i = 0; i < V; i++) {

            if(!visited[i]) {

                if(detectCycle(
                        graph,
                        visited,
                        recursionStack,
                        i)) {

                    System.out.println("Cycle exists");
                    return;
                }
            }
        }

        System.out.println("No cycle");
    }
}