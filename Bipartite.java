import java.util.*;

public class Bipartite{

    public static boolean dfs(ArrayList<Integer>[] graph){
        boolean[] isVis = new boolean[graph.length];
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=1; i<graph.length; i++){
            if(!isVis[i]){
                color[i] = 1; //1 --> white and 2 --> black
                if(!dfsUtil(graph,i,isVis,color)) return false;
            }
        }
        return true;
    }

    public static boolean dfsUtil(ArrayList<Integer>[] graph, int curr, boolean[] isVis, int[] color){
        isVis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            int v = graph[curr].get(i);
            if(color[v] == -1){
                color[v] = color[curr] == 1 ? 2 : 1;
                if(!dfsUtil(graph,v,isVis,color)) return false;
            }
            if(color[v] == color[curr]) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of vertices : ");
        int v = scn.nextInt();
        System.out.print("Enter number of edges : ");
        int e = scn.nextInt();
        int[] E1 = new int[e];
        int[] E2 = new int[e];
        System.out.println("Enter edges value e1 then e2 : ");
        for(int i=0; i<e; i++){
            E1[i] = scn.nextInt();
            E2[i] = scn.nextInt();
        }
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[v+1]; //Node marked from 1 to v
        for(int i=0; i<graph.length; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<e; i++){
            graph[E1[i]].add(E2[i]);
            graph[E2[i]].add(E1[i]);
        }
        System.out.println(dfs(graph));
    }
}