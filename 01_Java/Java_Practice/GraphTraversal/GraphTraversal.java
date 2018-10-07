// Java program to print DFS traversal from a given given graph
import java.io.*;
import java.util.*;
 

public class GraphTraversal
{
 
    public static void main(String args[])
    {
        //Creates an undirected graph
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.DFS(2);
        
        System.out.println("\nFollowing is Breadth First Traversal "+
                           "(starting from vertex 2)");
        g.BFS(2);
    }
}