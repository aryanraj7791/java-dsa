import java.util.*;

public class primsMST{

    public static class Edge{
        int dest;
        int wt;
        Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int v;
        int par;
        int cost;
        Pair(int v, int par, int cost){
            this.v = v;
            this.par = par;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    public static int prims(ArrayList<Edge>[] graph){

        boolean[] isVis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        int cost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!isVis[curr.v]){
                isVis[curr.v] = true;
                cost += curr.cost;
                if(curr.par != -1) System.out.println(curr.par+" ---> "+curr.v+" (Cost : "+curr.cost+")");
                for(Edge edge: graph[curr.v]){
                    if(!isVis[edge.dest]){
                        pq.add(new Pair(edge.dest,curr.v,edge.wt));
                    }
                }
            }
        }

        return cost;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 4;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1,10));
        graph[1].add(new Edge(0,10));
        graph[0].add(new Edge(2,15));
        graph[2].add(new Edge(0,15));
        graph[0].add(new Edge(3,30));
        graph[3].add(new Edge(0,30));
        graph[1].add(new Edge(3,40));
        graph[3].add(new Edge(1,40));
        graph[2].add(new Edge(3,50));
        graph[3].add(new Edge(2,50));

        System.out.println("Minimum cost is : "+prims(graph));
    }
}