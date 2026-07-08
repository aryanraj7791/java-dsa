import java.util.*;

public class MotherVertex{

    public static void motherVertex(ArrayList<Integer>[] graph, boolean[] isVis, int src){
        isVis[src] = true;
        for(int i: graph[src]){
            if(!isVis[i]){
                motherVertex(graph,isVis,i);
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

        graph[0].add(2);
        graph[0].add(3);
        graph[1].add(0);
        graph[2].add(1);
        graph[3].add(4);

        int a = 0;
        for(int i=0; i<graph.length; i++){
            boolean[] isVis = new boolean[v];
            boolean flag = true;
            motherVertex(graph,isVis,i);
            for(int j=0; j<isVis.length; j++){
                if(isVis[j] == false){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                a++;
                System.out.println("We can reach all vertices of this graph by starting at "+i);
            }
        }
        if(a == 0) System.out.println("There is not a single vertex through which all vertices can be reached!");
        System.out.println("Total vertex = "+a);
    }
}