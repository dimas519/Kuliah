package floyd_warshall;


import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;   
 
public class TestGraphs {
 
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        
        System.out.println("Graph:");
        int vertex=sc.nextInt();
        Graph g = new Graph(vertex);
        int vertex1,vertex2;
        float jarak;
        int i=0;
        while (i<vertex){
            vertex1=sc.nextInt();
            vertex2=sc.nextInt();
            jarak=sc.nextFloat();
            
            g.addEdge(vertex1,vertex2,jarak);
            
            i++;
        }
        
 
        // print Graph
        g.printGraph();
 
        // Floyd-Warshall All Pair Shortest Path Algorithm
        System.out.println("Floyd-Warshall All Pair Shortest Path Matrix:");
        FloydWarshall(g);
    }
 
    public static void FloydWarshall(Graph g) {
        int V = g.getvCount();
        
        // to store the calculated distances
        float dist[][] = new float[V][V];
 
        // initialize with adjacency matrix weight values
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = g.getAdj()[i][j];
            }
        }
 
        // loop through all vertices one by one
        for (int k = 0; k < V; k++) {
            // pick all as source
            for (int i = 0; i < V; i++) {
                // pick all as destination
                for (int j = 0; j < V; j++) {
                    // If k is on the shortest path from i to j
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        // update the value of dist[i][j]
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // shortest path matrix
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // if value is infinity
                if (dist[i][j] == Float.MAX_VALUE)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
        
    }
 
}

 
class Graph {
    private int vCount;
    private float[][] adj;
 
    public int getvCount() {
        return vCount;
    }
 
    public float[][] getAdj() {
        return adj;
    }
 
    public Graph(int vCount) {
        this.vCount = vCount;
        adj = new float[vCount][vCount];
        for (int i = 0; i < vCount; i++) {
            for (int j = 0; j < vCount; j++) {
                if (i != j) {
                    adj[i][j] = Float.MAX_VALUE;
                }
 
            }
        }
    }
 
    public void addEdge(int i, int j, float weight) {
        adj[i][j] = weight;
    }
 
    public void removeEdge(int i, int j) {
        adj[i][j] = Float.MAX_VALUE;
    }
 
    public boolean hasEdge(int i, int j) {
        if (adj[i][j] != Float.MAX_VALUE && adj[i][j] != 0) {
            return true;
        }
        return false;
    }
 
    public List<Integer> neighbours(int vertex) {
        List<Integer> edges = new ArrayList<Integer>();
        for (int i = 0; i < vCount; i++)
            if (hasEdge(vertex, i))
                edges.add(i);
        return edges;
    }
 
    public void printGraph() {
        for (int i = 0; i < vCount; i++) {
            List<Integer> edges = neighbours(i);
            System.out.print(i + ": ");
            for (int j = 0; j < edges.size(); j++) {
                System.out.print(edges.get(j) + " ");
            }
            System.out.println();
        }
    }
}