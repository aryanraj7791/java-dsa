import java.util.*;

public class MCM_Tabulation {

    public static int mcmTabulation(int[] arr){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //Initialisation
        for(int i=1; i<n; i++){
            dp[i][i] = 0;
        }

        //Computation
        for(int len=2; len<n; len++){
            for(int i=1; i<=n-len; i++){
                int j = i+len-1;
                int minCost = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    int finalCost = cost1 + cost2 + cost3;
                    minCost = Math.min(finalCost,minCost);
                }
                dp[i][j] = minCost;
            }
        }
        print(dp);
        return dp[1][n-1];
    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
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
        System.out.println("Minimum cost is : "+mcmTabulation(arr));
    }
}