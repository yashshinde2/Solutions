import java.util.*;

class AllPaths{

    static class Edge{

        int src;
        int dest;

        Edge(int s, int d){

            this.src = s;
            this.dest = d;

        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){

        for(int i=0; i<graph.length; i++){

            graph[i] = new ArrayList<Edge>();

        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }


    public static void allPaths(
            ArrayList<Edge> graph[],
            int curr,
            int dest,
            boolean vis[],
            ArrayList<Integer> path){

        path.add(curr);

        if(curr == dest){

            for(int i=0; i<path.size(); i++){

                System.out.print(path.get(i) + " ");

            }

            System.out.println();

            path.remove(path.size()-1);

            return;
        }

        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){

            Edge e = graph[curr].get(i);

            if(vis[e.dest] == false){

                allPaths(
                    graph,
                    e.dest,
                    dest,
                    vis,
                    path
                );

            }
        }

        vis[curr] = false;

        path.remove(path.size()-1);
    }


    public static void main(String[] args){

        int v = 7;

        ArrayList<Edge> graph[] = new ArrayList[v];

        createGraph(graph);

        boolean vis[] = new boolean[v];

        ArrayList<Integer> path = new ArrayList<>();

        int source = 0;
        int destination = 5;

        allPaths(
            graph,
            source,
            destination,
            vis,
            path
        );
    }
}