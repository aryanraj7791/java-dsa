import java.util.*;

public class CycleDetectionUndirectedDFS{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        } 
    }

    //O(V+E)
    private static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                if(detectCycleUtil(graph,i,isVisited,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean detectCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, int par){ //TC --> O(V+E) ; V -> vertex, E -> Edges

        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case-3
            if(!isVisited[e.dest]){
                if(detectCycleUtil(graph,e.dest,isVisited,curr)){
                    return true;
                }
            }
            //case-1
            else if(isVisited[e.dest] && e.dest != par){
                return true;
            }
            //case-2 --> Do nothing (continue)
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

    //Graph
    int v = 5;
    ArrayList<Edge>[] graph = new ArrayList[v]; //null(undefined) --> empty arraylist(defined)

    for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<>();
    }

    //0-vertex
    graph[0].add(new Edge(0,1));
    // graph[0].add(new Edge(0,2));
    graph[0].add(new Edge(0,3));
    //1-vertex
    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,2));
    //2-vertex
    // graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    //vertex-3
    graph[3].add(new Edge(3,0));
    graph[3].add(new Edge(3,4));
    //vertex-4
    graph[4].add(new Edge(4,3));
    
    System.out.println(detectCycle(graph));
    }
}