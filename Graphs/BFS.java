import java.util.*;

public class BFS{

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

    private static void bfs(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                bfsUtil(graph,isVisited,i);
            }
        }
    }

    private static void bfsUtil(ArrayList<Edge>[] graph, boolean[] isVisited, int idx){ //TC --> O(V+E)
        if(graph.length == 0) return;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx); //source = 0
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!isVisited[curr]){
                System.out.print(curr+" ");
                isVisited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
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
        graph[0].add(new Edge(0,1,5));
        //1-vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //2-vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));
        //vertex-3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        //vertex-4
        graph[4].add(new Edge(4,2,2));

        bfs(graph);
    }
}