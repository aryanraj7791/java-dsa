import java.util.*;

public class MCM_Recursion{

    public static int mcm(int[] arr, int i, int j){
        //Basecase
        if(i == j){
            return 0;
        }

        //Work in recursion
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcm(arr,i,k);
            int cost2 = mcm(arr,k+1,j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost,finalCost);
        }

        return minCost;
    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in the array : ");
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Minimum cost is : "+mcm(arr,1,n-1));
    }
}