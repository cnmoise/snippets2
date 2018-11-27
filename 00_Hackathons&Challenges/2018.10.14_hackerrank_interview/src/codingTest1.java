//demo for lin search and binary search
//need to complete
//
//        1 1 1 1 1 1
//        0 0 1 1 0 1
//        0 0 1 1 0 1
//        0 1 1 1 1 1
//        1 1 1 1 1 1
//
//static int digCanal(List<List<Integer>> area_map) {
//
//
//        }

import java.util.*;//to sue toString

public class codingTest1 {
    // Recursive Java implementation of Breadth first search
    public static void main(String[] args) {

        Integer[][] area_arr = {
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 0, 1, 1}};

        List<List<Integer>> area_map = new ArrayList<>();
        List<Integer> temp;

        for(int row=0;row< area_arr.length ;row++) {
            //converts a row of the array into an arrayList
            temp = Arrays.asList(area_arr[row]);
            //adds the entire row
            area_map.add(temp);
        }

        for(int row = 0; row < area_map.size(); row++)
        {
            for(int col = 0; col < area_map.get(row).size(); col++){
                System.out.print(area_map.get(row).get(col) + ",");
            }
            System.out.println();
        }


        // vector of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13 and 14 are single nodes
        );

        // Set number of vertices in the graph
        final int N = 15;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // create a queue used to do BFS
        Queue<Integer> q = new ArrayDeque<>();

        // Do BFS traversal from all undiscovered nodes to
        // cover all unconnected components of graph
        for (int i = 0; i < N; i++) {
            if (discovered[i] == false) {
                // mark source vertex as discovered
                discovered[i] = true;

                // push source vertex into the queue
                q.add(i);

                // start BFS traversal from vertex i
                recursiveBFS(graph, q, discovered);
            }
        }

    }

    public static void recursiveBFS(Graph graph, Queue<Integer> q, boolean[] discovered) {
        if (q.isEmpty())
            return;

        // pop front node from queue and print it
        int v = q.poll();
        System.out.print(v + " ");

        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v)) {
            if (!discovered[u]) {
                // mark it discovered and push it into queue
                discovered[u] = true;
                q.add(u);
            }
        }

        recursiveBFS(graph, q, discovered);
    }
}

class Edge
{
    int source, dest;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }
};

// class to represent a graph object
class Graph
{
    // An array of Lists to represent adjacency list
    // a list of nodes adjacent to that node
    List<List<Integer>> adjList = null;

    // Constructor
    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }

        // add edges to the undirected graph
        for (int i = 0; i < edges.size(); i++)
        {
            int src = edges.get(i).source;
            int dest = edges.get(i).dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
