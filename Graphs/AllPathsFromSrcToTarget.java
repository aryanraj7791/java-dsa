import java.util.*;

public class AllPathsFromSrcToTarget{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    
    private static boolean isPath = false;
    
    public static void allPaths(ArrayList<Edge>[] graph, int start, int end, StringBuilder path){

        path.append(start);

        if(start == end){
            isPath = true;
            System.out.println(path);
            return;
        }

        for(int i=0; i<graph[start].size(); i++){
            Edge e = graph[start].get(i);
            allPaths(graph,e.dest,end,path);
            path.deleteCharAt(path.length()-1);
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //Store graph in Array of ArrayList 
        //vertex-0
        graph[0].add(new Edge(0,3));
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

        allPaths(graph,4,1,new StringBuilder(""));
        if(!isPath){
            System.out.println("No path exist!");
        }
    }
}