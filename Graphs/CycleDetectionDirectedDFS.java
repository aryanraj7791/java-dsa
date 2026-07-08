import java.util.*;

public class CycleDetectionDirectedDFS{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                if(isCycleUtil(graph,i,isVisited,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, boolean[] stack){
        isVisited[curr] = true;
        stack[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!isVisited[e.dest] && isCycleUtil(graph,e.dest,isVisited,stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //Store graph in graph array
        //vertex-0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        //vertex-1
        graph[1].add(new Edge(1,3));
        //vertex-2
        graph[2].add(new Edge(2,3));

        System.out.println(isCycle(graph));
    }
}