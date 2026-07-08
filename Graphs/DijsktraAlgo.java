import java.util.*;

public class DijsktraAlgo{

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

    static class Pair implements Comparable<Pair>{
        
        int n;
        int dis;
        Pair(int n, int dis){
            this.n = n;
            this.dis = dis;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dis-p2.dis;
        }
    }

    public static void dijsktra(ArrayList<Edge>[] graph, int src){
        int[] dist = new int[graph.length];
        boolean[] isVis = new boolean[graph.length];

        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();
            if(!isVis[p.n]){
                isVis[p.n] = true;
                for(int i=0; i<graph[p.n].size(); i++){
                    Edge e = graph[p.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }

        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i]+" ");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));

        dijsktra(graph,0);
    }
}