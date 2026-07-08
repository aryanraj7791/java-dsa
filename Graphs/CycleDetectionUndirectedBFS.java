import java.util.*;

public class CycleDetectionUndirectedBFS{

    static class Edge{
        private int src;
        private int dest;
        Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static class NodeParent{
        int n;
        int par;
        NodeParent(int n, int par){
            this.n = n;
            this.par = par;
        }
    }

    public static boolean bfs(ArrayList<Edge>[] graph){
        boolean[] isVisited = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!isVisited[i]){
                if(bfsUtil(graph,i,isVisited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfsUtil(ArrayList<Edge>[] graph, int idx, boolean[] isVisited){
        Queue<NodeParent> q = new LinkedList<>();
        q.add(new NodeParent(idx,-1));
        isVisited[idx] = true;
        while(!q.isEmpty()){
            NodeParent curr = q.remove();
            for(int i=0; i<graph[curr.n].size(); i++){
                Edge e = graph[curr.n].get(i);
                if(!isVisited[e.dest]){
                    isVisited[e.dest] = true;
                    q.add(new NodeParent(e.dest,curr.n));
                }
                else if(isVisited[e.dest] && e.dest != curr.par){
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        int v = 5;
        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //0-vertex
        graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        //1-vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        //2-vertex
        // graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        //vertex-3
        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        //vertex-4
        graph[4].add(new Edge(4,3));

        System.out.println(bfs(graph));
        
    }
}