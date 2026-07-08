import java.util.*;

    public class SlidingWindowMaximum2{

    public static int[] slidingWindowMax(int []arr, int size){
        Deque<Integer> dq = new ArrayDeque<>();
        int res[] = new int[arr.length-size+1];
        for(int i=0; i<arr.length; i++){
            if(!dq.isEmpty() && dq.getFirst()<=i-size){
                dq.removeFirst();
            }
            while(dq.size()>0 && arr[dq.getLast()]<arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i>=size-1){
                res[i-size+1] = arr[dq.getFirst()];
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
        //print ans array
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]+" ");
        }
    }
}