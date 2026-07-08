import java.util.*;

public class BridgeInGraph{

    public static void dfs(ArrayList<Integer>[] graph, int curr, int par, boolean[] isVis, int[] dis, int[] low, int time){
        isVis[curr] = true;
        dis[curr] = low[curr] = ++time;
        for(int neighbour: graph[curr]){
            if(neighbour == par){
                continue;
            }
            else if(!isVis[neighbour]){
                dfs(graph,neighbour,curr,isVis,dis,low,time);
                low[curr] = Math.min(low[curr],low[neighbour]);
                if(dis[curr] < low[neighbour]){
                    System.out.println("Bridge edge : "+curr+" --> "+neighbour);
                }
            }
            else{
                low[curr] = Math.min(low[curr],dis[neighbour]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Integer>[] graph, int v){
        int[] dis = new int[v];
        int[] low = new int[v];
        int time = 0;
        boolean[] isVis = new boolean[v];

        for(int i=0; i<graph.length; i++){
            if(!isVis[i]){
                dfs(graph,i,-1,isVis,dis,low,time);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 6;
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
        // graph[3].add(5);
        // graph[5].add(3);
        // graph[4].add(5);
        // graph[5].add(4);

        tarjanBridge(graph,v);
    }
}