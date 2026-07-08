import java.util.*;

public class Knapsack{
 
    //TC--> O(n*W)
    public static int knapsackMem(int[] val, int[] wt, int W, int n, int[][] dp){
        if(W == 0 || n == 0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }
        else{
            if(wt[n-1] <= W){
                //include
                int ans1 = val[n-1] + knapsackMem(val, wt, W-wt[n-1], n-1, dp);
                //exclude
                int ans2 = knapsackMem(val, wt, W, n-1, dp);
                dp[n][W] = Math.max(ans1, ans2);
                return dp[n][W];
            }
            else{
                dp[n][W] = knapsackMem(val, wt, W, n-1, dp);
                return dp[n][W];
            }
        }

    }

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsackTab(int[] val, int[] wt, int W, int n){
        int[][] dp = new int[n+1][W+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int v = val[i-1];
                int w = wt[i-1];
                if(w <= j){ //Valid case
                    int incProfit = v + dp[i-1][j-w];
                    int excprofit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excprofit);
                }else{ //Invalid case
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void main(String[] args){
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int n = wt.length;

        int[][] dp = new int[n+1][W+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println("Maximum profit is : "+knapsackMem(val,wt,W,n,dp));
        System.out.println("Maximum profit is : "+knapsackTab(val,wt,W,n));
    }
}