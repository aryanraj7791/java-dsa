import java.util.*;

public class MaxCandies{

    public static int maxCandies(int N, int K, int[] cost, int[][] edges){
        @SuppressWarnings("unchecked")
        //Build Graph using adjacency list
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) graph[i] = new ArrayList<>();
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        
        //compute parent array
        int[] par = new int[N+1];
        Arrays.fill(par,-1);

        Stack<int[]> s = new Stack<>();
        s.push(new int[]{1,-1});

        while(!s.isEmpty()){
            int[] arr = s.pop();
            int u = arr[0];
            int p = arr[1];
            par[u] = p;
            for(int v : graph[u]){
                if(v != p) s.push(new int[]{v,u});
            }
        }

        //Count candies
        int candies=0;
        for(int u=1; u<=N; u++){
            int money = K;
            int count = 0;
            int curr = u;
            while(curr != -1 && money >= cost[curr]){
                money -= cost[curr];
                count++;
                curr = par[curr];
            }
            candies = Math.max(candies,count);
        }
        return candies;        
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int K = scn.nextInt();
        int[][] edges = new int[N-1][2];
        for(int i=0; i<N-1; i++){
            edges[i][0] = scn.nextInt();
            edges[i][1] = scn.nextInt();
        }
        int[] cost = new int[N+1];
        for(int i=1; i<=N; i++){
            cost[i] = scn.nextInt();
        }
        System.out.println(maxCandies(N,K,cost,edges));
    }
}