import java.util.*;

public class StronglyConnectedComponents{

    public static Stack<Integer> topoSort(ArrayList<Integer>[] graph){
        boolean[] isVis = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<graph.length; i++){
            if(!isVis[i]){
                topoSortUtil(graph,i,isVis,s);
            }
        }
        return s;
    }

    public static void topoSortUtil(ArrayList<Integer>[] graph, int curr, boolean[] isVis, Stack<Integer> s){
        isVis[curr] = true;
        for(int neighbour: graph[curr]){
            if(!isVis[neighbour]){
                topoSortUtil(graph,neighbour,isVis,s);
            }
        }
        s.push(curr);
    }

    
    @SuppressWarnings("unchecked")
    public static ArrayList<Integer>[] transverse(ArrayList<Integer>[] graph){
        ArrayList<Integer>[] trans = new ArrayList[graph.length];
        for(int i=0; i<trans.length; i++){
            trans[i] = new ArrayList<>();
        }
        for(int i=0; i<graph.length; i++){
            for(int neighbour: graph[i]){
                trans[neighbour].add(i);
            }
        }
        return trans;
    }

    public static void bfs(ArrayList<Integer>[] transGraph, int src, boolean[] isVis){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            isVis[curr] = true;
            System.out.print(curr+" ");
            for(int neighbour: transGraph[curr]){
                if(!isVis[neighbour]){
                    q.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public static int kosaraju(ArrayList<Integer>[] graph){
        //Step-1: store the topological sorting order for the given graph into stack
        Stack<Integer> s = topoSort(graph);
        //Step-2: Transverse the graph
        ArrayList<Integer>[] transGraph = transverse(graph);
        //Step-3: Do the DFS on the transverse graph in the order of nodes coming out of the stack
        boolean[] isVis = new boolean[transGraph.length];
        int count = 0;
        while(!s.isEmpty()){
            int x = s.pop();
            if(!isVis[x]){
                bfs(transGraph,x,isVis);
                count++;
            }
        }
        return count;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        int v = 5;
        ArrayList<Integer>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        //Creating Graph
        graph[0].add(2);
        graph[0].add(3);
        graph[1].add(0);
        graph[2].add(1);
        graph[3].add(4);

        int res = kosaraju(graph);
        System.out.println("Total SCC is : "+res);
    }
}