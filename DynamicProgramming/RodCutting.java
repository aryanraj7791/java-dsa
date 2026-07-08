import java.util.*;

public class RodCutting{

    public static int maxProfitTab(int[] length, int[] prices, int rodLength){
        int n = prices.length;
        //Create and initialise table
        int[][] dp = new int[n+1][rodLength+1];
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }

        for(int j=1; j<dp[0].length; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                int len = length[i-1];
                if(len <= j){
                    //include
                    int ans1 = prices[i-1] + dp[i][j-len];
                    //exclude
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                }
                else{
                    //exclude
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodLength];
    }

    public static void main(String[] args){
        int[] length = {1,2,3,4,5,6,7,8};
        int[] prices = {1,5,8,9,10,17,17,20};
        int rodLength = 15;

        System.out.println("Max profit is : "+maxProfitTab(length, prices, rodLength));
    }
}