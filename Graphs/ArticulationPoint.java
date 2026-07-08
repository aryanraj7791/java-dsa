import java.util.*;

public class ArticulationPoint{

    public static void dfs(ArrayList<Integer>[] graph, int curr, int par, int[] dt, int[] low, int time, boolean[] isVis, boolean[] ap){
        isVis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int neigh: graph[curr]){
            if(par == neigh){
                continue;
            }
            else if(!isVis[neigh]){
                dfs(graph,neigh,curr,dt,low,time,isVis,ap);
                low[curr] = Math.min(low[curr],low[neigh]);
                if(par != -1 && dt[curr] <= low[neigh]){
                    ap[curr] = true;
                }
                children++;
            }
            else{
                low[curr] = Math.min(low[curr],dt[neigh]);
            }
        }
        if(par == -1){
                if(children > 1){
                    ap[curr] = true;
                }
            }
    }

    public static void articulationPoint(ArrayList<Integer>[] graph, int v){
        int[] dt = new int[v];
        int[] low = new int[v];
        int time = 0;
        int children = 0;
        boolean[] isVis = new boolean[v];
        boolean[] ap = new boolean[v];

        for(int i=0; i<graph.length; i++){
            if(!isVis[i]){
                dfs(graph,i,-1,dt,low,time,isVis,ap);
            }
        }

        for(int i=0; i<ap.length; i++){
            if(ap[i]){
                System.out.println("AP is : "+i);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 5;
        ArrayList<Integer>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(1);
        graph[1].add(0);
        graph[0].add(2);
        graph[2].add(0);
        graph[0].add(3);
        graph[3].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[3].add(4);
        graph[4].add(3);

        articulationPoint(graph,v);
    }
}