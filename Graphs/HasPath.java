import java.util.*;

public class HasPath{

    static class Edge{
        private int src;
        private int dest;
        private int wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        } 
    }

    private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] isVisited){ //TC --> O(V+E) ; V -> vertex, E -> Edges
        
        if(src == dest) return true;

        isVisited[src] = true;

        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!isVisited[e.dest] && hasPath(graph,e.dest,dest,isVisited)){
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

    //Graph
    int v = 7;
    ArrayList<Edge>[] graph = new ArrayList[v]; //null(undefined) --> empty arraylist(defined)

    for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<>();
    }

    //0-vertex
    graph[0].add(new Edge(0,1,1));
    graph[0].add(new Edge(0,2,1));
    //1-vertex
    graph[1].add(new Edge(1,0,1));
    graph[1].add(new Edge(1,3,1));
    //2-vertex
    graph[2].add(new Edge(2,0,1));
    graph[2].add(new Edge(2,4,1));
    //vertex-3
    graph[3].add(new Edge(3,1,1));
    graph[3].add(new Edge(3,4,1));
    graph[3].add(new Edge(3,5,1));
    //vertex-4
    graph[4].add(new Edge(4,2,1));
    graph[4].add(new Edge(4,3,1));
    graph[4].add(new Edge(4,5,1));
    //vertex-5
    graph[5].add(new Edge(5,3,1));
    graph[5].add(new Edge(5,4,1));
    graph[5].add(new Edge(5,6,1));
    //vertex-6
    graph[6].add(new Edge(6,5,1));

    boolean ans = hasPath(graph,0,5,new boolean[v]);
    if(ans) System.out.println("Path exist!");
    else System.out.println("Path does not exist!");
    }
}