import java.util.*;

public class SlidingWindowMaximum1{

    public static class Pair implements Comparable<Pair>{
        int val;
        int idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.val-this.val;
        }
    }

    public static int[] slidingWindowMax(int []arr, int size){ //TC-O(nlogn),SC-O(n)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int res[] = new int[arr.length-size+1];
        for(int i=0; i<arr.length; i++){
            pq.add(new Pair(arr[i],i));
            if(i>=size-1){
                while(pq.size()>0 && pq.peek().idx <= i-size){
                    pq.remove();
                }
                res[i-size+1] = pq.peek().val;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of elements in array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in array : ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Enter size of window : ");
        int size = scn.nextInt();
        int ans[] = slidingWindowMax(arr,size);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}