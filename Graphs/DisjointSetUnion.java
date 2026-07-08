import java.util.*;

public class DisjointSetUnion{

    static int n = 7;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init(){
        for(int i=0; i<par.length; i++){
            par[i] = i;
        }
    }

    public static int find(int target){
        if(target == par[target]){
            return target;
        }
        return par[target] = find(par[target]); //path compression
    }

    public static void union(int x, int y){
        int par_x = find(x);
        int par_y = find(y);
        if(rank[par_x] == rank[par_y]){
            par[par_y] = par_x;
            rank[par_x]++;
        }
        else if(rank[par_x] < rank[par_y]){
            par[par_x] = par_y;
        }
        else{
            par[par_y] = par_x;
        }
    }

    public static void main(String[] args){
        init();
        System.out.println(find(3));
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }
}