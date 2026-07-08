import java.util.*;

public class DFS{

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

    private static void dfs(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                dfsUtil(graph,i,isVisited);
            }
        }
    }

    private static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited){ //TC --> O(V+E) ; V -> vertex, E -> Edges

        System.out.print(curr+" ");
        isVisited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            int neighbor = graph[curr].get(i).dest;
            if(!isVisited[neighbor]){
                dfsUtil(graph,neighbor,isVisited);
            }
        }
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

    dfs(graph);
    }
}