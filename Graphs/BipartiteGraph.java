import java.util.*;

public class BipartiteGraph{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){ //no color
                if(!isBipartiteUtil(graph,i,color)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartiteUtil(ArrayList<Edge>[] graph, int idx, int[] color){
        color[idx] = 0; //yellow for 0 and Blue for 1
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(color[e.dest] == -1){
                    color[e.dest] = color[curr] == 0 ? 1 : 0;
                    q.add(e.dest);
                }else if(color[e.dest] == color[curr]){
                    return false; //Not Bipartite graph
                }
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        //If graph doesn't have cycle then it is a Bipartite graph
        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //store graph in Array of arraylist
        //vertex-0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        //vertex-1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        //vertex-2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));
        //vertex-3
        graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,4));
        //vertex-4
        graph[4].add(new Edge(4,2));
        // graph[4].add(new Edge(4,3));

        System.out.println(isBipartite(graph));
    }
}
