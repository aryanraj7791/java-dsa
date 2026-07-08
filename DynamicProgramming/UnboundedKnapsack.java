import java.util.*;

public class UnboundedKnapsack{

    public static void print(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //TC --> O(n * W)
    public static int unboundedKnapsack(int[] val, int[] wt, int W){
        int n = val.length;
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
                int w = wt[i-1];
                if(w <= j){
                    //include
                    int ans1 = val[i-1] + dp[i][j-w];
                    //exclude
                    int ans2 = dp[i-1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                }else{
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

        System.out.println("Max profit is : "+unboundedKnapsack(val,wt,W));
    }
}