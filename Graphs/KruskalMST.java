import java.util.*;

public class KruskalMST{

    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;
        Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt-e2.wt;
        }
    }

    static int v = 4;
    static int[] par = new int[v];
    static int[] rank = new int[v];

    public static void init(){
        for(int i=0; i<par.length; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
        int par_a = find(a);
        int par_b = find(b);
        if(rank[par_a] == rank[par_b]){
            par[par_b] = par_a;
            rank[par_a]++;
        }
        else if(rank[par_a] < rank[par_b]){
            par[par_a] = par_b;
        }
        else{
            par[par_b] = par_a;
        }
    }

    public static int kruskalMst(ArrayList<Edge> edges){ //O(V+ElogE)
        Collections.sort(edges); //O(ElogE)
        int mstCost = 0;
        int count=0;
        
        for(int i=0; i<edges.size() && count<v-1; i++){
            Edge edge = edges.get(i);
            int a = edge.src;
            int b = edge.dest;
            int par_a = find(a);
            int par_b = find(b);
            if(par_a != par_b){
                union(a,b);
                mstCost += edge.wt;
                count++;
            }
        }
        return mstCost;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
       init();
       ArrayList<Edge> edges = new ArrayList<>();
       edges.add(new Edge(0,1,10));
       edges.add(new Edge(0,2,15));
       edges.add(new Edge(0,3,30));
       edges.add(new Edge(1,3,40));
       edges.add(new Edge(2,3,50));

       System.out.println("Minimum cost MST is : "+kruskalMst(edges));
    }
}