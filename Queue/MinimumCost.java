import java.util.*;

public class MinimumCost{
    public static int minimumCost(int []ropes){
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //min heap
        int totalCost = 0;
        for(int i=0; i<ropes.length; i++){
            pq.add(ropes[i]);
        }
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            pq.add(a+b);
            totalCost += a+b;
        }
        return totalCost;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of ropes : ");
        int n = scn.nextInt();
        int []ropes = new int[n];
        System.out.println("Enter length of ropes : ");
        for(int i=0; i<n; i++){
            ropes[i] = scn.nextInt();
        }
        System.out.print("Minimum cost to connect all "+n+" ropes is : "+minimumCost(ropes));
    }
}