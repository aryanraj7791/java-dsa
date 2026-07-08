import java.util.*;

public class KahnAlgoTopoSortBFS{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    public static void computeInDegree(ArrayList<Edge>[] graph, int[] inDegree){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void kahnAlgo(ArrayList<Edge>[] graph){
        int[] inDegree = new int[graph.length];
        computeInDegree(graph,inDegree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<graph.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //Store graph
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

        kahnAlgo(graph);
    }
}