import java.util.*;

public class ConnectingCities{

    static class Edge{
        int dest;
        int wt;
        public Edge(int dest, int wt){
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    public static int connectingCities(ArrayList<Edge>[] graph){
        boolean[] isVis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int cost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!isVis[curr.v]){
                isVis[curr.v] = true;
                cost += curr.cost;
                for(Edge e: graph[curr.v]){
                    if(!isVis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        return cost;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int cities[][] = {{0,1,2,3,4},
                           {1,0,5,0,7},
                           {2,5,0,6,0},
                           {3,0,6,0,0},
                           {4,7,0,0,0}};
        ArrayList<Edge>[] graph = new ArrayList[cities.length];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<cities.length; i++){
            for(int j=0; j<cities[i].length; j++){
                if(cities[i][j] != 0){
                    graph[i].add(new Edge(j,cities[i][j]));
                }
            }
        }
        System.out.println("Minimum cost for connecting cities is : "+connectingCities(graph));
    }
}