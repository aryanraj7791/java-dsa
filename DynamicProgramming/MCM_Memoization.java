import java.util.*;

public class MCM_Memoization {

    public static int mcmMemoization(int arr[], int dp[][], int i, int j){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcmMemoization(arr,dp,i,k);
            int cost2 = mcmMemoization(arr,dp,k+1,j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1 + cost2 + cost3;
            minCost = Math.min(minCost,finalCost);
        }

        return dp[i][j] = minCost;
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
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("Minimum cost is : "+mcmMemoization(arr,dp,1,n-1));
        scn.close();
    }
}