import java.util.*;

class UndirectedCycle {

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
            int curr,
            int parent) {

        visited[curr] = true;

        for(Edge e : graph[curr]) {

            if(!visited[e.dest]) {

                if(detectCycle(
                        graph,
                        visited,
                        e.dest,
                        curr)) {

                    return true;
                }
            }

    
            else if(e.dest != parent) {

                return true;
            }
        }

        return false;
    }
}