import java.util.*;

public class TopologicalSorting{

    static class Edge{
        int src;
        int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph){ //TC --> O(V+E); Sc --> O(V)
        boolean[] isVisited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                topologicalSortUtil(graph,i,isVisited,s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, Stack<Integer> s){
        isVisited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!isVisited[e.dest]){
                topologicalSortUtil(graph,e.dest,isVisited,s);
            }
        }

        s.push(curr);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v=6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //store graph in Array of ArrayList<Edge>
        //vertex-2
        graph[2].add(new Edge(2,3));
        //vertex-3
        graph[3].add(new Edge(3,1));
        //vertex-4
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        //vertex-5
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));

        topologicalSort(graph);
    }
}