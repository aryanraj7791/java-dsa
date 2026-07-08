import java.util.*;

//Kadanes Algorithm works when atleast one element in the array is positive;
public class KadanesAlgo{

    public static int kadanes(int arr[]){
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=0){
                flag = true;
                break;
            }
        }
        if(flag == false){
            int max=Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            return max;
             }
        else{
            int cs = 0, ms = Integer.MIN_VALUE;
            for(int i=0; i<arr.length; i++){
                cs = cs + arr[i];
                if(cs<0){
                   cs = 0;
                  }
                ms = Math.max(cs,ms);
            }
             return ms;
        }
}

    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter elements in the array: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }
        System.out.print("Max subArray sum is: " + kadanes(arr));
    }
}