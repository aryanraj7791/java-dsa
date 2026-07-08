import java.util.*;

public class CycleDetectionUsingDSU{

    public static int find(int a, int[] par){
        if(par[a] == a){
            return a;
        }
        return par[a] = find(par[a],par);
    }

    public static boolean union(int a, int b, int[] par, int[] rank){
        int parA = find(a,par);
        int parB = find(b,par);
        if(parA == parB){
            return true;
        }
        else{
            if(rank[parA] == rank[parB]){
                par[parB] = parA;
                rank[parA]++;
            }
            else if(rank[parA] < rank[parB]){
                par[parA] = parB;
            }else{
                par[parB] = parA;
            }
        }
        return false;
    }

    public static void unionFind(int[][] edges, int max){
        int[] par = new int[max+1];
        int[] rank = new int[max+1];
        for(int i=0; i<=max; i++){
            par[i] = i;
            rank[i] = 0;
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            if(union(a,b,par,rank)){
                System.out.println("Cycle exists!");
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 5;
        int[][] edges = {
            {1,9},
            {9,5},
            {1,5},
            {5,2},
            {2,7}
        };
        int[] vertices = {1,2,5,7,9};
        int max=-1;
        for(int i=0; i<vertices.length; i++){
            max = Math.max(max,vertices[i]);
        }
        unionFind(edges,max);
    }
}