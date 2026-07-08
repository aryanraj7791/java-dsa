import java.util.*;

public class BellmanFordAlgo{

    public static class Edge{
        int dest;
        int wt;
        Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src) dist[i] = Integer.MAX_VALUE;
        }
        int v = graph.length;
        //Algorithm--> TC is O(V*E)
        for(int i=0; i<v-1; i++){
            //Edges-> O(E)
            for(int u=0; u<v; u++){
                for(Edge edge: graph[u]){
                    //Relaxation
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+edge.wt<dist[edge.dest]){
                    dist[edge.dest] = dist[u]+edge.wt;
                }
                }
            }
        }
        //negative weight cycle detection
        for(int u=0; u<v; u++){
            for(Edge edge: graph[u]){
                if(dist[u] != Integer.MAX_VALUE && dist[u]+edge.wt < dist[edge.dest]){
                    System.out.println("Graph contains negative weight cycle!");
                    return;
                }
            }
        }
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();

        graph[0].add(new Edge(1,2));
        graph[0].add(new Edge(2,4));
        graph[1].add(new Edge(2,-4));
        graph[2].add(new Edge(3,2));
        graph[3].add(new Edge(4,4));
        graph[4].add(new Edge(1,-1));

        bellmanFord(graph,0);
    }
}