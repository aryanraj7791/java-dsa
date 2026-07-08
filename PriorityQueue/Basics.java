import java.util.*;

public class Basics{
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements in priority queue : ");
        int n = scn.nextInt();
        System.out.print("Enter elements in priority queue : ");
        for(int i=0; i<n; i++){
            pq.add(scn.nextInt());
        }
        while(!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }
}